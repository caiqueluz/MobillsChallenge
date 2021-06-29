package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.content.res.Resources
import br.com.concrete.canarinho.formatador.FormatadorValor
import com.caiqueluz.mobillschallenge.DateConverter
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
    private val resources: Resources,
    private val dateConverter: DateConverter
) {

    fun convert(transactions: List<Transaction>): List<TransactionVO> =
        when (transactions.transactionType()) {
            REVENUE -> convertRevenues(transactions as List<Revenue>)
            EXPENSE -> convertExpenses(transactions as List<Expense>)
        }

    private fun convertRevenues(revenues: List<Revenue>): List<RevenueVO> =
        revenues.map { revenue ->
            val value: String =
                FormatadorValor.VALOR_COM_SIMBOLO
                    .formata(revenue.value.toString())

            RevenueVO(
                value = value,
                description = revenue.description,
                date = dateConverter.convert(revenue.date),
                received = getReceivedValue(revenue)
            )
        }

    private fun convertExpenses(expenses: List<Expense>): List<ExpenseVO> =
        expenses.map { expense ->
            val value: String =
                FormatadorValor.VALOR_COM_SIMBOLO
                    .formata(expense.value.toString())

            ExpenseVO(
                value = value,
                description = expense.description,
                date = dateConverter.convert(expense.date),
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
