package com.caiqueluz.mobillschallenge.transaction

import java.math.BigDecimal
import java.util.*

abstract class Transaction(
    open val value: BigDecimal,
    open val description: String,
    open val date: Date
)
