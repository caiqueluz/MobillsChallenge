package com.caiqueluz.mobillschallenge.transaction.alltransactions

import android.content.Intent
import androidx.lifecycle.*
import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import com.caiqueluz.mobillschallenge.transaction.main.TransactionFlow
import com.caiqueluz.mobillschallenge.transaction.main.TransactionType

class AllTransactionsViewModel(
    private val repository: TransactionRepository,
    private val converter: AllTransactionsConverter,
    private val intentFactory: IntentFactory
) : ViewModel() {

    private val _navigate = MutableLiveData<Intent>()
    val navigate: LiveData<Intent> = _navigate

    private val _transactions = MutableLiveData<TransactionType>()
    val transactions: LiveData<List<TransactionVO>> = _transactions.switchMap { type ->
        liveData {
            val transactions = repository.getAll(type)

            if (transactions.isEmpty().not()) {
                val result = converter.convert(transactions)
                emit(value = result)
            }
        }
    }

    fun onStart(transactionType: TransactionType) {
        _transactions.postValue(transactionType)
    }

    fun onAddButtonClicked(transactionType: TransactionType) {
        val intent = intentFactory.createTransactionIntent(
            TransactionFlow.AddTransaction(transactionType)
        )

        _navigate.postValue(intent)
    }
}
