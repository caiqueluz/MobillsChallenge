package com.caiqueluz.mobillschallenge.expense

import android.content.res.Resources
import br.com.concrete.canarinho.formatador.FormatadorValor
import com.caiqueluz.mobillschallenge.DateConverter
import com.caiqueluz.mobillschallenge.R

class ExpenseConverter(
    private val dateConverter: DateConverter,
    private val resources: Resources
) {

    fun convert(expenses: List<Expense>): List<ExpenseVO> =
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

    private fun getPaidValue(expense: Expense): String =
        if (expense.paid) {
            resources.getString(R.string.expense_paid_value)
        } else {
            resources.getString(R.string.expense_not_paid_value)
        }
}
