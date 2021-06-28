package com.caiqueluz.mobillschallenge.expense

import com.caiqueluz.mobillschallenge.transaction.Transaction
import java.math.BigDecimal
import java.util.*

data class Expense(
    override val value: BigDecimal,
    override val description: String,
    override val date: Date,
    val paid: Boolean
) : Transaction(value, description, date)
