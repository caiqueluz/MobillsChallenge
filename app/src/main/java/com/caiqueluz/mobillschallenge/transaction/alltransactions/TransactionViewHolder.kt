package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.caiqueluz.mobillschallenge.databinding.ExpenseListItemBinding
import com.caiqueluz.mobillschallenge.databinding.RevenueListItemBinding
import com.caiqueluz.mobillschallenge.expense.ExpenseVO
import com.caiqueluz.mobillschallenge.revenue.RevenueVO

sealed class TransactionViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    class RevenueViewHolder(
        private val binding: RevenueListItemBinding
    ) : TransactionViewHolder(binding.root) {

        fun bind(revenue: RevenueVO) {
            with(binding) {
                revenueValue.text = revenue.value
                revenueDescription.text = revenue.description
                revenueDate.text = revenue.date
                revenueReceived.text = revenue.received
            }
        }
    }

    class ExpenseViewHolder(
        val binding: ExpenseListItemBinding
    ) : TransactionViewHolder(binding.root) {

        fun bind(expense: ExpenseVO) {
            with(binding) {
                expenseValue.text = expense.value
                expenseDescription.text = expense.description
                expenseDate.text = expense.date
                expensePaid.text = expense.paid
            }
        }
    }
}
