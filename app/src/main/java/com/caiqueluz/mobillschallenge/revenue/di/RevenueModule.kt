package com.caiqueluz.mobillschallenge.revenue.di

import com.caiqueluz.mobillschallenge.revenue.addrevenue.AddRevenueViewModel
import com.caiqueluz.mobillschallenge.revenue.allrevenues.AllRevenuesConverter
import com.caiqueluz.mobillschallenge.revenue.allrevenues.AllRevenuesViewModel
import com.caiqueluz.mobillschallenge.revenue.data.DefaultRevenueRepository
import com.caiqueluz.mobillschallenge.revenue.data.RevenueRepository
import com.caiqueluz.mobillschallenge.revenue.main.RevenueViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val revenueModule = module {

    single<RevenueRepository> {
        DefaultRevenueRepository(get())
    }

    factory {
        AllRevenuesConverter(get())
    }

    viewModel {
        RevenueViewModel()
    }

    viewModel {
        AllRevenuesViewModel(get(), get(), get())
    }

    viewModel {
        AddRevenueViewModel(get())
    }
}
