package com.caiqueluz.mobillschallenge.transaction.alltransactions

import com.caiqueluz.mobillschallenge.expense.Expense
import com.caiqueluz.mobillschallenge.expense.ExpenseConverter
import com.caiqueluz.mobillschallenge.revenue.Revenue
import com.caiqueluz.mobillschallenge.revenue.RevenueConverter
import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.EXPENSE
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.REVENUE

@Suppress("UNCHECKED_CAST")
class AllTransactionsConverter(
    private val revenueConverter: RevenueConverter,
    private val expenseConverter: ExpenseConverter
) {

    fun convert(transactions: List<Transaction>): List<TransactionVO> =
        when (transactions.transactionType()) {
            REVENUE -> revenueConverter.convert(transactions as List<Revenue>)
            EXPENSE -> expenseConverter.convert(transactions as List<Expense>)
        }
}

private fun List<Transaction>.transactionType(): TransactionType =
    TransactionType.of(this[0])
