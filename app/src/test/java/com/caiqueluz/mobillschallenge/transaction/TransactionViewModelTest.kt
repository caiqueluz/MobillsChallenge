package com.caiqueluz.mobillschallenge.transaction

import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.ConcurrentTest
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow
import com.caiqueluz.mobillschallenge.transaction.main.TransactionViewModel
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class TransactionViewModelTest : ConcurrentTest() {

    private val viewModel = TransactionViewModel()

    @Test
    fun whenOnFlowReceivedIsCalled_verifyObserverValueIsCorrect() {
        val observer = mock<Observer<TransactionFlow>>()
        viewModel.navigate.observeForever(observer)

        val expected = mock<TransactionFlow>()
        viewModel.onFlowReceived(expected)

        verify(observer).onChanged(eq(expected))
    }
}
