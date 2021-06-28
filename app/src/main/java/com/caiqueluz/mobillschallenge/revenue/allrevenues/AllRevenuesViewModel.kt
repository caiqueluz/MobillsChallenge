package com.caiqueluz.mobillschallenge.revenue.allrevenues

import android.content.Intent
import androidx.lifecycle.*
import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.revenue.data.RevenueRepository
import com.caiqueluz.mobillschallenge.revenue.main.RevenueFlow

class AllRevenuesViewModel(
    private val repository: RevenueRepository,
    private val converter: AllRevenuesConverter,
    private val intentFactory: IntentFactory
) : ViewModel() {

    private val _navigate = MutableLiveData<Intent>()
    val navigate: LiveData<Intent> = _navigate

    private val _revenues = MutableLiveData<Unit>()
    val revenues: LiveData<List<RevenueVO>> = _revenues.switchMap {
        liveData {
            val revenues = repository.getAll()
            emit(value = converter.convert(revenues))
        }
    }

    fun onStart() {
        _revenues.postValue(Unit)
    }

    fun onAddButtonClicked() {
        val flow = RevenueFlow.AddRevenue
        val intent = intentFactory.createRevenueIntent(flow)

        _navigate.postValue(intent)
    }
}
