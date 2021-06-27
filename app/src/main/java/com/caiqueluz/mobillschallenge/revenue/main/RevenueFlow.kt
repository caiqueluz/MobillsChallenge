package com.caiqueluz.mobillschallenge.revenue.main

import com.caiqueluz.mobillschallenge.revenue.data.Revenue
import java.io.Serializable

sealed class RevenueFlow : Serializable {

    object AddRevenue : RevenueFlow()

    class RevenueDetail(val revenue: Revenue) : RevenueFlow()
}
