package kz.sayat.weatherapp.ui

data class WeatherItem (
        val cityName: String,
        val temperatureKelvin: Float,
        val feelsLikeKelvin: Float,
        val humidity: Int,
        val windSpeed: Float
) {
    val temperatureCelsius: Int
        get() = (temperatureKelvin - 273).toInt()

    val feelsLikeTemperatureCelsius: Int
        get() = (feelsLikeKelvin - 273).toInt()

}
