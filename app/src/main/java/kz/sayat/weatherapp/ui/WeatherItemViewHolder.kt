package kz.sayat.weatherapp.ui

import androidx.recyclerview.widget.RecyclerView
import kz.sayat.weatherapp.R
import kz.sayat.weatherapp.databinding.ItemCityWeatherBinding

class WeatherItemViewHolder(private val binding: ItemCityWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(weatherItem: WeatherItem) {
        binding.apply {
            val context = binding.root.context
            cityName.text = weatherItem.cityName
            temperature.text = String.format(context.getString(R.string.celsius), weatherItem.temperatureCelsius)
            feelsLike.text = String.format(context.getString(R.string.celsius), weatherItem.feelsLikeTemperatureCelsius)
            humidity.text = String.format(context.getString(R.string.percent), weatherItem.humidity)
            windSpeed.text = String.format(context.getString(R.string.m_s), weatherItem.windSpeed)
        }
    }
}