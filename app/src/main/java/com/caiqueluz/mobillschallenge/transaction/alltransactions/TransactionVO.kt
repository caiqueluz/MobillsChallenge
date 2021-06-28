package com.caiqueluz.mobillschallenge.transaction.alltransactions

import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

abstract class TransactionVO(
    open val value: String,
    open val description: String,
    open val date: String,
    open val type: TransactionType
)
