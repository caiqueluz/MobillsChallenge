package com.caiqueluz.mobillschallenge.di

import com.caiqueluz.mobillschallenge.IntentFactory
import com.caiqueluz.mobillschallenge.home.di.homeModule
import com.caiqueluz.mobillschallenge.revenue.di.revenueModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {

    single {
        androidContext().resources
    }

    single {
        IntentFactory(get())
    }
}

val appModules = listOf(
    applicationModule,
    homeModule,
    revenueModule
)
