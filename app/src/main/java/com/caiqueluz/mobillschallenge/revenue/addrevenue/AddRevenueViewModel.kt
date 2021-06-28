package com.caiqueluz.mobillschallenge.revenue.addrevenue

import androidx.lifecycle.*
import com.caiqueluz.mobillschallenge.asValidBigDecimal
import com.caiqueluz.mobillschallenge.revenue.data.Revenue
import com.caiqueluz.mobillschallenge.revenue.data.RevenueRepository
import java.util.*

class AddRevenueViewModel(
    private val revenueRepository: RevenueRepository
) : ViewModel() {

    private val _saveRevenue = MutableLiveData<Revenue>()
    val saveRevenue: LiveData<Boolean> = _saveRevenue.switchMap { revenue ->
        liveData {
            val result = revenueRepository.save(revenue)
            emit(result)
        }
    }

    fun onAddRevenueRequested(
        value: String,
        description: String,
        date: Date,
        received: Boolean
    ) {
        val revenue = Revenue(value.asValidBigDecimal(), description, date, received)
        _saveRevenue.postValue(revenue)
    }
}
