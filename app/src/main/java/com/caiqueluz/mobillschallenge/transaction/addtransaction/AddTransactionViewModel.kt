package com.caiqueluz.mobillschallenge.transaction.addtransaction

import androidx.lifecycle.*
import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType
import java.util.*

class AddTransactionViewModel(
    private val repository: TransactionRepository,
    private val factory: TransactionFactory
) : ViewModel() {

    private val _addTransaction = MutableLiveData<Transaction>()
    val addTransaction: LiveData<Boolean> = _addTransaction.switchMap { transaction ->
        liveData {
            val result = repository.save(transaction)
            emit(result)
        }
    }

    fun onAddTransactionRequested(
        type: TransactionType,
        value: String,
        description: String,
        date: Date,
        status: Boolean
    ) {
        val transaction = when (type) {
            TransactionType.REVENUE -> factory.createRevenueTransaction(
                value, description, date, status
            )

            TransactionType.EXPENSE -> factory.createExpenseTransaction(
                value, description, date, status
            )
        }

        _addTransaction.postValue(transaction)
    }
}
