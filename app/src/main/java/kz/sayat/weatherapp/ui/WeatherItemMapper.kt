package kz.sayat.weatherapp.ui

import kz.sayat.weatherapp.domain.Mapper
import kz.sayat.weatherapp.domain.WeatherResponse

class WeatherItemMapper : Mapper<WeatherResponse, WeatherItem> {
    override fun map(from: WeatherResponse): WeatherItem {
        return WeatherItem(from.name, from.main.temp, from.main.feels_like, from.main.humidity, from.wind.speed)
    }
}