package com.caiqueluz.mobillschallenge.di

import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.home.di.homeModule
import com.caiqueluz.mobillschallenge.transaction.di.transactionModule
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {

    single {
        androidContext().resources
    }

    single {
        IntentFactory(get())
    }

    single {
        Dispatchers.IO
    }
}

val appModules = listOf(
    applicationModule,
    homeModule,
    transactionModule
)
