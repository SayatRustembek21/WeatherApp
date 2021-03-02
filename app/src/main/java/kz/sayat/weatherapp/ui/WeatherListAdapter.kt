package kz.sayat.weatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sayat.weatherapp.databinding.ItemCityWeatherBinding
import kz.sayat.weatherapp.domain.WeatherResponse

class WeatherListAdapter : ListAdapter<WeatherResponse, WeatherItemViewHolder>(WeatherDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemViewHolder {
        return WeatherItemViewHolder(ItemCityWeatherBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: WeatherItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WeatherDiffUtil : DiffUtil.ItemCallback<WeatherResponse>() {
        override fun areItemsTheSame(oldItem: WeatherResponse, newItem: WeatherResponse): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: WeatherResponse,
            newItem: WeatherResponse
        ): Boolean {
            return oldItem.name == newItem.name
        }

    }

}