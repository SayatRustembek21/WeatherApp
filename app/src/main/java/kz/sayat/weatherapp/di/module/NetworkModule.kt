package kz.sayat.weatherapp.di.module

import kz.sayat.weatherapp.network.Configurations.provideApiService
import kz.sayat.weatherapp.network.Configurations.provideOkHttpClient
import kz.sayat.weatherapp.network.Configurations.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
}