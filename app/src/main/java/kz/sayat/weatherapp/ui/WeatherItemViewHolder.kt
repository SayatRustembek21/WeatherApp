package kz.sayat.weatherapp.ui

import androidx.recyclerview.widget.RecyclerView
import kz.sayat.weatherapp.databinding.ItemCityWeatherBinding
import kz.sayat.weatherapp.domain.WeatherResponse

class WeatherItemViewHolder(private val binding: ItemCityWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(weatherResponse: WeatherResponse) {
        binding.apply {
            cityName.text = weatherResponse.name
            temperature.text = weatherResponse.main.feels_like.toString()
        }
    }
}