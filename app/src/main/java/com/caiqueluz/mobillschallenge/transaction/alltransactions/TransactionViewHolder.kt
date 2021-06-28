package com.caiqueluz.mobillschallenge.transaction.alltransactions

import com.caiqueluz.mobillschallenge.databinding.ExpenseListItemBinding
import com.caiqueluz.mobillschallenge.databinding.RevenueListItemBinding
import com.caiqueluz.mobillschallenge.expense.ExpenseVO
import com.caiqueluz.mobillschallenge.revenue.RevenueVO

sealed class TransactionViewHolder {

    class RevenueViewHolder(
        val binding: RevenueListItemBinding
    ) : TransactionViewHolder() {

        fun bind(revenue: RevenueVO) {
            //
        }
    }

    class ExpenseViewHolder(
        val binding: ExpenseListItemBinding
    ) : TransactionViewHolder() {

        fun bind(expense: ExpenseVO) {
            //
        }
    }
}
