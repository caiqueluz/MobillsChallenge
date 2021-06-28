package com.caiqueluz.mobillschallenge

import android.text.TextWatcher
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import java.math.BigDecimal

fun CurrencyTextWatcher(): TextWatcher =
    ValorMonetarioWatcher.Builder()
        .comMantemZerosAoLimpar()
        .build()

fun String.asValidBigDecimal(): BigDecimal =
    this.replace(",", ".").toBigDecimal()
