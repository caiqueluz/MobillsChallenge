package com.caiqueluz.mobillschallenge.transaction.main

import com.caiqueluz.mobillschallenge.expense.Expense
import com.caiqueluz.mobillschallenge.revenue.Revenue
import com.caiqueluz.mobillschallenge.transaction.Transaction
import java.io.Serializable

enum class TransactionType : Serializable {

    REVENUE,
    EXPENSE;

    companion object {

        fun of(transaction: Transaction): TransactionType =
            when (transaction) {
                is Revenue -> REVENUE
                is Expense -> EXPENSE
                else -> throw error(
                    "ERROR: transaction of type '${transaction::class.java.simpleName}' is unknown"
                )
            }
    }
}
