package com.caiqueluz.mobillschallenge.transaction.di

import com.caiqueluz.mobillschallenge.transaction.addtransaction.AddTransactionViewModel
import com.caiqueluz.mobillschallenge.transaction.addtransaction.TransactionFactory
import com.caiqueluz.mobillschallenge.transaction.alltransactions.AllTransactionsConverter
import com.caiqueluz.mobillschallenge.transaction.alltransactions.AllTransactionsViewModel
import com.caiqueluz.mobillschallenge.transaction.data.DefaultTransactionRepository
import com.caiqueluz.mobillschallenge.transaction.data.TransactionRepository
import com.caiqueluz.mobillschallenge.transaction.main.TransactionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val transactionModule = module {

    single<TransactionRepository> {
        DefaultTransactionRepository(get())
    }

    factory {
        AllTransactionsConverter(get())
    }

    factory {
        TransactionFactory()
    }

    viewModel {
        TransactionViewModel()
    }

    viewModel {
        AllTransactionsViewModel(get(), get(), get())
    }

    viewModel {
        AddTransactionViewModel(get(), get())
    }
}
