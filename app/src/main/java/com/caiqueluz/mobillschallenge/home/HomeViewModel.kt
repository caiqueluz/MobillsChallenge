package com.caiqueluz.mobillschallenge.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class HomeViewModel(
    private val tabItemFactory: TabItemFactory
) : ViewModel() {

    private val _tabItems = MutableLiveData<Unit>()
    val tabItems: LiveData<List<TabItemVO>> = _tabItems.map {
        tabItemFactory.createItems()
    }

    init {
        _tabItems.postValue(Unit)
    }
}
