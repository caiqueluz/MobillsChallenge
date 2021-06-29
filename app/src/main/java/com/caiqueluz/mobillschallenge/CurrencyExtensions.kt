package com.caiqueluz.mobillschallenge

import android.text.TextWatcher
import br.com.concrete.canarinho.formatador.FormatadorValor
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import java.math.BigDecimal

fun CurrencyTextWatcher(): TextWatcher =
    ValorMonetarioWatcher.Builder()
        .comMantemZerosAoLimpar()
        .build()

fun String.asValidBigDecimal(): BigDecimal {
    val double: Double =
        FormatadorValor.VALOR
            .desformata(this)
            .toDoubleOrNull() ?: 0.0

    return double.toBigDecimal()
}
