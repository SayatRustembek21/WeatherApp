package kz.sayat.weatherapp.di.module

import kz.sayat.weatherapp.ui.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        MainActivityViewModel(get(), get())
    }
}