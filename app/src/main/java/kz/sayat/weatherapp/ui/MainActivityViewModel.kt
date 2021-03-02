package kz.sayat.weatherapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kz.sayat.weatherapp.domain.WeatherResponse
import kz.sayat.weatherapp.network.ApiService

class MainActivityViewModel(app: Application, private val apiService: ApiService): AndroidViewModel(app) {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _weatherList = MutableLiveData<List<WeatherResponse>>()
    val weatherList: LiveData<List<WeatherResponse>>
        get() = _weatherList

    init {
        _error.value = "Example error"
    }

    fun addWeatherByCityName() {
        viewModelScope {

        }
    }
}