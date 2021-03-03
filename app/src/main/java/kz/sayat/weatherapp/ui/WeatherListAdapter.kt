package kz.sayat.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sayat.weatherapp.databinding.ItemCityWeatherBinding

class WeatherListAdapter : ListAdapter<WeatherItem, WeatherItemViewHolder>(WeatherDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemViewHolder {
        return WeatherItemViewHolder(ItemCityWeatherBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: WeatherItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WeatherDiffUtil : DiffUtil.ItemCallback<WeatherItem>() {
        override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
            return oldItem.cityName == newItem.cityName
        }

        override fun areContentsTheSame(
            oldItem: WeatherItem,
            newItem: WeatherItem
        ): Boolean {
            return oldItem.cityName == newItem.cityName
        }

    }

}