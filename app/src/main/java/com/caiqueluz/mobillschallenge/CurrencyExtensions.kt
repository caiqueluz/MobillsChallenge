package com.caiqueluz.mobillschallenge

import android.text.TextWatcher
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher

fun CurrencyTextWatcher(): TextWatcher =
    ValorMonetarioWatcher.Builder()
        .comMantemZerosAoLimpar()
        .build()
