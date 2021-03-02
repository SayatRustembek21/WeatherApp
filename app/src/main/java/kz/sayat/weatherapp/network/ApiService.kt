package kz.sayat.weatherapp.network

import kz.sayat.weatherapp.BuildConfig
import kz.sayat.weatherapp.domain.WeatherErrorResponse
import kz.sayat.weatherapp.domain.WeatherResponse
import kz.sayat.weatherapp.network.responseConverterFactory.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun getWeatherByCityName(@Query("q") cityName: String,
                             @Query("appid") apiKey: String = BuildConfig.API_KEY) : NetworkResponse<WeatherResponse, WeatherErrorResponse>

}