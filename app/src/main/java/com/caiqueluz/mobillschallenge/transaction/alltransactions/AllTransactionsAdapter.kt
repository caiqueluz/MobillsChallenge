package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caiqueluz.mobillschallenge.databinding.ExpenseListItemBinding
import com.caiqueluz.mobillschallenge.databinding.RevenueListItemBinding
import com.caiqueluz.mobillschallenge.expense.ExpenseVO
import com.caiqueluz.mobillschallenge.revenue.RevenueVO
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

private const val REVENUE_VIEW_TYPE = 0
private const val EXPENSE_VIEW_TYPE = 1

class AllTransactionsAdapter(
    private val context: Context,
    private val transactions: List<TransactionVO>
) : RecyclerView.Adapter<TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder =
        viewHolderOf(viewType, parent)

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]

        when (transaction.type) {
            TransactionType.REVENUE -> {
                (holder as TransactionViewHolder.RevenueViewHolder).bind(transaction as RevenueVO)
            }

            TransactionType.EXPENSE -> {
                (holder as TransactionViewHolder.ExpenseViewHolder).bind(transaction as ExpenseVO)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (transactions[position].type) {
            TransactionType.REVENUE -> REVENUE_VIEW_TYPE
            TransactionType.EXPENSE -> EXPENSE_VIEW_TYPE
        }

    override fun getItemCount(): Int = transactions.size

    private fun viewHolderOf(viewType: Int, parent: ViewGroup): TransactionViewHolder =
        when (viewType) {
            REVENUE_VIEW_TYPE -> TransactionViewHolder.RevenueViewHolder(
                binding = RevenueListItemBinding.inflate(
                    LayoutInflater.from(context), parent, false
                )
            )

            EXPENSE_VIEW_TYPE -> TransactionViewHolder.ExpenseViewHolder(
                binding = ExpenseListItemBinding.inflate(
                    LayoutInflater.from(context), parent, false
                )
            )

            else -> throw error("ERROR: TransactionViewHolder of type '$viewType' is unknown")
        }
}
