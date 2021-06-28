package com.caiqueluz.mobillschallenge.transaction.addtransaction

import androidx.lifecycle.*
import com.caiqueluz.mobillschallenge.asValidBigDecimal
import com.caiqueluz.mobillschallenge.revenue.Revenue
import com.caiqueluz.mobillschallenge.transaction.Transaction
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import java.util.*

class AddTransactionViewModel(
    private val repository: TransactionRepository
) : ViewModel() {

    private val _addTransaction = MutableLiveData<Transaction>()
    val addTransaction: LiveData<Boolean> = _addTransaction.switchMap { transaction ->
        liveData {
            val result = repository.save(transaction)
            emit(result)
        }
    }

    fun onAddTransactionRequested(
        value: String,
        description: String,
        date: Date,
        received: Boolean
    ) {
        val revenue = Revenue(value.asValidBigDecimal(), description, date, received)
        _addTransaction.postValue(revenue)
    }
}
