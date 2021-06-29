package com.caiqueluz.mobillschallenge

import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.FormatadorValor
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import java.math.BigDecimal

private const val DEFAULT_VALUE = 0.0

fun CurrencyTextWatcher(): TextWatcher =
    ValorMonetarioWatcher.Builder()
        .comMantemZerosAoLimpar()
        .build()

fun String.asValidBigDecimal(): BigDecimal {
    val value = if (this.isBlank() || this.isEmpty()) DEFAULT_VALUE.toString() else this

    val double: Double =
        try {
            FormatadorValor.VALOR
                .desformata(value)
                .toDouble()
        } catch (exception: Exception) {
            0.0
        }

    return double.toBigDecimal()
}
