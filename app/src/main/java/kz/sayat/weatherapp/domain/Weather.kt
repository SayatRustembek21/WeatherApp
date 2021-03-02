package kz.sayat.weatherapp.domain

data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)
