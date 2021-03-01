package kz.sayat.weatherapp

import android.app.Application
import kz.sayat.weatherapp.di.module.networkModule
import kz.sayat.weatherapp.di.module.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModelsModule))
        }
    }

}