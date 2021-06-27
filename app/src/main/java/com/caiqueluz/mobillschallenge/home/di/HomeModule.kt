package com.caiqueluz.mobillschallenge.home.di

import com.caiqueluz.mobillschallenge.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel {
        HomeViewModel(get())
    }
}
