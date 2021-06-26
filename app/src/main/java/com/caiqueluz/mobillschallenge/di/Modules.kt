package com.caiqueluz.mobillschallenge.di

import com.caiqueluz.mobillschallenge.home.TabItemFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val generalModule = module {

    single {
        androidContext().resources
    }

    factory {
        TabItemFactory(get())
    }
}

val appModules = listOf(
    generalModule
)
