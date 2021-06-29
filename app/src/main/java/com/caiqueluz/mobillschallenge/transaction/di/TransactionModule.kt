package com.caiqueluz.mobillschallenge.transaction.di

import com.caiqueluz.mobillschallenge.DateConverter
import com.caiqueluz.mobillschallenge.DialogFactory
import com.caiqueluz.mobillschallenge.expense.ExpenseConverter
import com.caiqueluz.mobillschallenge.revenue.RevenueConverter
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
        DateConverter()
    }

    factory {
        RevenueConverter(get(), get())
    }

    factory {
        ExpenseConverter(get(), get())
    }

    factory {
        AllTransactionsConverter(get(), get())
    }

    factory {
        TransactionFactory()
    }

    factory {
        DialogFactory(get())
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
