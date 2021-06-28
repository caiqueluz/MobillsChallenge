package com.caiqueluz.mobillschallenge.revenue

import com.caiqueluz.mobillschallenge.transaction.alltransactions.TransactionVO
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

class RevenueVO(
    override val value: String,
    override val description: String,
    override val date: String,
    val received: String
) : TransactionVO(value, description, date, TransactionType.REVENUE)
