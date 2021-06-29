package com.caiqueluz.mobillschallenge.transaction.addtransaction

import com.caiqueluz.mobillschallenge.asValidBigDecimal
import com.caiqueluz.mobillschallenge.expense.Expense
import com.caiqueluz.mobillschallenge.revenue.Revenue
import java.util.*

class TransactionFactory {


    fun createRevenueTransaction(
        value: String,
        description: String,
        date: Date,
        received: Boolean
    ): Revenue =
        Revenue(value.asValidBigDecimal(), description, date, received)

    fun createExpenseTransaction(
        value: String,
        description: String,
        date: Date,
        paid: Boolean
    ): Expense =
        Expense(value.asValidBigDecimal(), description, date, paid)
}
