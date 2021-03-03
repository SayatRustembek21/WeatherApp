package kz.sayat.weatherapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kz.sayat.weatherapp.App
import kz.sayat.weatherapp.R
import kz.sayat.weatherapp.network.ApiService
import kz.sayat.weatherapp.network.responseConverterFactory.NetworkResponse

class MainActivityViewModel(app: Application,
                            private val apiService: ApiService,
                            private val weatherItemMapper: WeatherItemMapper) : AndroidViewModel(app) {

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    private val _weatherList = MutableLiveData<List<WeatherItem>>(listOf())
    val weatherList: LiveData<List<WeatherItem>>
        get() = _weatherList

    private val _scrollToTop = MutableLiveData<Boolean>(false)
    val scrollToTop: LiveData<Boolean>
        get() = _scrollToTop

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    fun addWeatherByCityName(cityName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            when (val apiService = apiService.getWeatherByCityName(cityName)) {
                is NetworkResponse.Success -> {
                    _weatherList.value = mutableListOf(weatherItemMapper.map(apiService.body)).apply {
                        addAll(_weatherList.value?.toList().orEmpty())
                    }

                    delay(100L)
                    scrollToTop()
                }
                is NetworkResponse.ApiError -> {
                    _error.value = apiService.body.message
                }
                is NetworkResponse.NetworkError -> {
                    _error.value = getApplication<App>().getString(R.string.network_connection_problem)
                }
                is NetworkResponse.UnknownError -> {
                    _error.value = getApplication<App>().getString(R.string.unhandled_error)
                }
            }
            _isLoading.value = false
        }
    }

    private fun scrollToTop() {
        _scrollToTop.value = true
        _scrollToTop.value = false
    }
}