package com.caiqueluz.mobillschallenge

import android.content.Context
import android.content.Intent
import com.caiqueluz.mobillschallenge.revenue.main.RevenueActivity
import com.caiqueluz.mobillschallenge.revenue.main.RevenueFlow

const val REVENUE_FLOW_KEY = "REVENUE_FLOW"

class IntentFactory(
    private val context: Context
) {

    fun createRevenueIntent(revenueFlow: RevenueFlow): Intent {
        val intent = Intent(context, RevenueActivity::class.java)
        intent.putExtra(REVENUE_FLOW_KEY, revenueFlow)

        return intent
    }
}
