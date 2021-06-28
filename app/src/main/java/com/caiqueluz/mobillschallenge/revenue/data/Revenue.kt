package com.caiqueluz.mobillschallenge.revenue.data

import java.math.BigDecimal
import java.util.*

data class Revenue(
    val value: BigDecimal,
    val description: String,
    val date: Date,
    val received: Boolean
)
