package com.caiqueluz.mobillschallenge.revenue.allrevenues

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caiqueluz.mobillschallenge.databinding.RevenueListItemBinding

class AllRevenuesAdapter(
    private val context: Context,
    private val revenues: List<RevenueVO>
) : RecyclerView.Adapter<AllRevenuesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            binding = RevenueListItemBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val revenue = revenues[position]
        holder.bind(revenue)
    }

    override fun getItemCount(): Int = revenues.size

    inner class ViewHolder(
        private val binding: RevenueListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(revenue: RevenueVO) {
            with(binding) {
                revenueValue.text = revenue.value
                revenueDescription.text = revenue.description
                revenueDate.text = revenue.date
                revenueReceived.text = revenue.received
            }
        }
    }
}
