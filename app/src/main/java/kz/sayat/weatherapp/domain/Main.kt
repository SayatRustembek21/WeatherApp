package kz.sayat.weatherapp.domain

data class Main(
        val temp: Float,
        val feels_like: Float,
        val temp_min: Float,
        val temp_max: Float,
        val pressure: Int,
        val humidity: Int
)