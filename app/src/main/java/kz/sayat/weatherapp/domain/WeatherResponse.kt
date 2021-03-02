package kz.sayat.weatherapp.domain

data class WeatherResponse(
        val weather : List<Weather>,
        val base: String,
        val main: Main,
        val visibility: Int,
        val wind: Wind,
        val name: String,
        val code: Int
)
