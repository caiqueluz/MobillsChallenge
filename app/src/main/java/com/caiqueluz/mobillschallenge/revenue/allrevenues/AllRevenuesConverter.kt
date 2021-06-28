package com.caiqueluz.mobillschallenge.revenue.allrevenues

import android.content.res.Resources
import com.caiqueluz.mobillschallenge.R
import com.caiqueluz.mobillschallenge.revenue.data.Revenue

class AllRevenuesConverter(
    private val resources: Resources
) {

    fun convert(revenues: List<Revenue>): List<RevenueVO> =
        revenues.map { revenue ->
            val received = getReceivedValue(revenue)

            RevenueVO(
                value = revenue.value.toString(),
                description = revenue.description,
                date = revenue.date.toString(),
                received = received
            )
        }

    private fun getReceivedValue(revenue: Revenue): String =
        if (revenue.received) {
            resources.getString(R.string.revenue_received_value)
        } else {
            resources.getString(R.string.revenue_not_received_value)
        }
}
