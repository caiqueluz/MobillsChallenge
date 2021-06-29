package com.caiqueluz.mobillschallenge.transaction

import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.caiqueluz.mobillschallenge.ConcurrentTest
import com.caiqueluz.mobillschallenge.transaction.addtransaction.AddTransactionViewModel
import com.caiqueluz.mobillschallenge.transaction.addtransaction.TransactionFactory
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AddTransactionViewModelTest : ConcurrentTest() {

    private val mockRepository = mock<TransactionRepository>()
    private val mockTransactionFactory = mock<TransactionFactory>()

    private val viewModel = AddTransactionViewModel(
        mockRepository, mockTransactionFactory
    )

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withRevenueTransactionType_verifyTransactionFactoryIsCreatingRevenue() {
        val expected = TransactionType.REVENUE

        viewModel.onAddTransactionRequested(
            type = expected, "0.0", "description", mock(), true
        )

        verify(mockTransactionFactory).createRevenueTransaction(any(), any(), any(), any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withExpenseTransactionType_verifyTransactionFactoryIsCreatingExpense() {
        val expected = TransactionType.EXPENSE

        viewModel.onAddTransactionRequested(
            type = expected, "0.0", "description", mock(), true
        )

        verify(mockTransactionFactory).createExpenseTransaction(any(), any(), any(), any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_verifyTransactionFactoryIsCalledWithCorrectValue() {
        val expected = "0.0"

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, value = expected, "description", mock(), true
        )

        verify(mockTransactionFactory).createRevenueTransaction(eq(expected), any(), any(), any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withValidDescription_verifyTransactionFactoryIsCalledWithCorrectDescription() {
        val expected = "description"

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, "0.0", description = expected, mock(), true
        )

        verify(mockTransactionFactory).createRevenueTransaction(any(), eq(expected), any(), any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withValidDescription_verifyAddTransactionObserverHasBeenChanged() =
        runBlockingTest {
            whenever(mockRepository.save(any())).thenReturn(true)
            whenever(
                mockTransactionFactory.createRevenueTransaction(
                    any(), any(), any(), any()
                )
            ).thenReturn(mock())

            val observer = mock<Observer<Boolean>>()
            viewModel.addTransaction.observeForever(observer)

            viewModel.onAddTransactionRequested(
                TransactionType.REVENUE, "0.0", "description", mock(), true
            )

            verify(observer).onChanged(any())
        }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withEmptyDescription_verifyInvalidDescriptionObserverHasBeenChanged() {
        val observer = mock<Observer<Unit>>()
        viewModel.invalidDescription.observeForever(observer)

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, "0.0", "", mock(), true
        )

        verify(observer).onChanged(any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_withBlankDescription_verifyInvalidDescriptionObserverHasBeenChanged() {
        val observer = mock<Observer<Unit>>()
        viewModel.invalidDescription.observeForever(observer)

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, "0.0", "   ", mock(), true
        )

        verify(observer).onChanged(any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_verifyTransactionFactoryIsCalledWithCorrectDate() {
        val expected = Date()

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, "0.0", "description", date = expected, true
        )

        verify(mockTransactionFactory).createRevenueTransaction(any(), any(), eq(expected), any())
    }

    @Test
    fun whenOnAddTransactionRequestedIsCalled_verifyTransactionFactoryIsCalledWithCorrectStatus() {
        val expected = true

        viewModel.onAddTransactionRequested(
            TransactionType.REVENUE, "0.0", "description", mock(), expected
        )

        verify(mockTransactionFactory).createRevenueTransaction(any(), any(), any(), eq(expected))
    }
}
