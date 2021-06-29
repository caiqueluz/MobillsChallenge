package com.caiqueluz.mobillschallenge.transaction

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.ConcurrentTest
import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.transaction.alltransactions.AllTransactionsConverter
import com.caiqueluz.mobillschallenge.transaction.alltransactions.AllTransactionsViewModel
import com.caiqueluz.mobillschallenge.transaction.alltransactions.TransactionVO
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AllTransactionsViewModelTest : ConcurrentTest() {

    private val mockRepository = mock<TransactionRepository>()
    private val mockConverter = mock<AllTransactionsConverter>()
    private val mockIntentFactory = mock<IntentFactory>()

    private val viewModel = AllTransactionsViewModel(
        mockRepository, mockConverter, mockIntentFactory
    )

    @Test
    fun whenOnStartIsCalled_verifyRepositoryIsCalledWithCorrectTransactionType() = runBlockingTest {
        val observer = mock<Observer<List<TransactionVO>>>()
        viewModel.transactions.observeForever(observer)

        val expected = mock<TransactionType>()
        viewModel.onStart(expected)

        verify(mockRepository).getAll(eq(expected))
    }

    @Test
    fun whenOnStartIsCalled_withTransactionsSaved_verifyConverterIsCalled() = runBlockingTest {
        whenever(mockRepository.getAll(any())).thenReturn(listOf(mock()))

        val observer = mock<Observer<List<TransactionVO>>>()
        viewModel.transactions.observeForever(observer)

        val expected = mock<TransactionType>()
        viewModel.onStart(expected)

        verify(mockConverter).convert(any())
    }

    @Test
    fun whenOnStartIsCalled_withoutTransactionsSaved_verifyConverterIsNotCalled() =
        runBlockingTest {
            whenever(mockRepository.getAll(any())).thenReturn(listOf())

            val observer = mock<Observer<List<TransactionVO>>>()
            viewModel.transactions.observeForever(observer)

            val expected = mock<TransactionType>()
            viewModel.onStart(expected)

            verifyZeroInteractions(mockConverter)
        }

    @Test
    fun whenOnStartIsCalled_withoutTransactionsSaved_verifyObserverHasNotBeenChanged() =
        runBlockingTest {
            val observer = mock<Observer<List<TransactionVO>>>()
            viewModel.transactions.observeForever(observer)

            val expected = mock<TransactionType>()
            viewModel.onStart(expected)

            verifyZeroInteractions(observer)
        }

    @Test
    fun whenOnAddButtonClicked_verifyIntentFactoryIsCalledWithCorrectTransactionFlow() {
        val observer = mock<Observer<Intent>>()
        viewModel.navigate.observeForever(observer)

        viewModel.onAddButtonClicked(mock())

        val captor = argumentCaptor<TransactionFlow>()
        verify(mockIntentFactory).createTransactionIntent(captor.capture())

        val expected = TransactionFlow.AddTransaction(mock()).javaClass
        val actual = captor.lastValue.javaClass

        assertEquals(expected, actual)
    }

    @Test
    fun whenOnAddButtonClicked_verifyIntentFactoryIsCalledWithCorrectTransactionType() {
        val observer = mock<Observer<Intent>>()
        viewModel.navigate.observeForever(observer)

        val mockTransactionType = mock<TransactionType>()
        viewModel.onAddButtonClicked(mockTransactionType)

        val captor = argumentCaptor<TransactionFlow>()
        verify(mockIntentFactory).createTransactionIntent(captor.capture())

        val actual = captor.lastValue.transactionType

        assertEquals(mockTransactionType, actual)
    }
}
