package com.caiqueluz.mobillschallenge.transaction.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {

    private val _navigate = MutableLiveData<TransactionFlow>()
    val navigate: LiveData<TransactionFlow> = _navigate

    fun onFlowReceived(flow: TransactionFlow) {
        _navigate.postValue(flow)
    }
}
