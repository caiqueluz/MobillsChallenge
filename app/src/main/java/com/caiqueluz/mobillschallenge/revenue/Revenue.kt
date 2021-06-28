package com.caiqueluz.mobillschallenge.revenue

import com.caiqueluz.mobillschallenge.transaction.Transaction
import java.math.BigDecimal
import java.util.*

data class Revenue(
    override val value: BigDecimal,
    override val description: String,
    override val date: Date,
    val received: Boolean
) : Transaction(value, description, date)
