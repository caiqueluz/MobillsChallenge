package com.caiqueluz.mobillschallenge.revenue.allrevenues

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.revenue.main.RevenueFlow

class AllRevenuesViewModel(
    private val intentFactory: IntentFactory
) : ViewModel() {

    private val _navigate = MutableLiveData<Intent>()
    val navigate: LiveData<Intent> = _navigate

    fun onAddButtonClicked() {
        val flow = RevenueFlow.AddRevenue
        val intent = intentFactory.createRevenueIntent(flow)

        _navigate.postValue(intent)
    }
}
