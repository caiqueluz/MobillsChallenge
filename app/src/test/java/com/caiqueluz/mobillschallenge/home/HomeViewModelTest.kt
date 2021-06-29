package com.caiqueluz.mobillschallenge.home

import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.ConcurrentTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class HomeViewModelTest : ConcurrentTest() {

    private val mockTabItemFactory = mock<TabItemFactory>()
    private lateinit var viewModel: HomeViewModel

    @Test
    fun whenStarted_verifyObserverHasBeenChanged() {
        viewModel = HomeViewModel(mockTabItemFactory)

        val observer = mock<Observer<List<TabItemVO>>>()
        viewModel.tabItems.observeForever(observer)

        verify(observer).onChanged(any())
    }
}
