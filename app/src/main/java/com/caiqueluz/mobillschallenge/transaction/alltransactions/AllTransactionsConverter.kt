package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.content.res.Resources
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.expense.Expense
import com.caiqueluz.mobillschallenge.expense.ExpenseVO
import com.caiqueluz.mobillschallenge.revenue.Revenue
import com.caiqueluz.mobillschallenge.revenue.RevenueVO
import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.EXPENSE
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType.REVENUE

@Suppress("UNCHECKED_CAST")
class AllTransactionsConverter(
    private val resources: Resources
) {

    fun convert(transactions: List<Transaction>): List<TransactionVO> =
        when (transactions.transactionType()) {
            REVENUE -> convertRevenues(transactions as List<Revenue>)
            EXPENSE -> convertExpenses(transactions as List<Expense>)
        }

    private fun convertRevenues(revenues: List<Revenue>): List<RevenueVO> =
        revenues.map { revenue ->
            RevenueVO(
                value = revenue.value.toString(),
                description = revenue.description,
                date = revenue.date.toString(),
                received = getReceivedValue(revenue)
            )
        }

    private fun convertExpenses(expenses: List<Expense>): List<ExpenseVO> =
        expenses.map { expense ->
            ExpenseVO(
                value = expense.value.toString(),
                description = expense.description,
                date = expense.date.toString(),
                paid = getPaidValue(expense)
            )
        }

    private fun getReceivedValue(revenue: Revenue): String =
        if (revenue.received) {
            resources.getString(R.string.revenue_received_value)
        } else {
            resources.getString(R.string.revenue_not_received_value)
        }

    private fun getPaidValue(expense: Expense): String =
        if (expense.paid) {
            resources.getString(R.string.expense_paid_value)
        } else {
            resources.getString(R.string.expense_not_paid_value)
        }
}

private fun List<Transaction>.transactionType(): TransactionType = TransactionType.of(this[0])
