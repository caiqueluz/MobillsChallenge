package com.caiqueluz.mobillschallenge.home.di

import com.caiqueluz.mobillschallenge.home.HomeViewModel
import com.caiqueluz.mobillschallenge.home.TabItemFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    factory {
        TabItemFactory(get())
    }

    viewModel {
        HomeViewModel(get())
    }
}
