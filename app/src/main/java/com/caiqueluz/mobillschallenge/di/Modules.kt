package com.caiqueluz.mobillschallenge.di

import com.caiqueluz.mobillschallenge.TabItemFactory
import org.koin.dsl.module

val generalModule = module {

    factory {
        TabItemFactory(get())
    }
}

val appModules = listOf(
    generalModule
)
