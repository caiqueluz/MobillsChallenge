package com.caiqueluz.mobillschallenge.revenue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caiqueluz.mobillschallenge.R

typealias Destination = Int

class RevenueViewModel : ViewModel() {

    private val _navigate = MutableLiveData<Destination>()
    val navigate: LiveData<Destination> = _navigate

    fun onFlowReceived(flow: RevenueFlow) {
        val destination = when (flow) {
            is RevenueFlow.AddRevenue -> R.id.add_revenue_fragment
            is RevenueFlow.RevenueDetail -> R.id.revenue_detail_fragment
        }

        _navigate.postValue(destination)
    }
}
