package kz.sayat.weatherapp.di.module

import kz.sayat.weatherapp.ui.WeatherItemMapper
import org.koin.dsl.module

val appModule = module {
    factory { WeatherItemMapper() }
}
