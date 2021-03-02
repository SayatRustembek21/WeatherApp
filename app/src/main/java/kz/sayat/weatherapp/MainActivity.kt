package kz.sayat.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kz.sayat.weatherapp.databinding.ActivityMainBinding
import kz.sayat.weatherapp.ui.MainActivityViewModel
import kz.sayat.weatherapp.ui.WeatherListAdapter
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = WeatherListAdapter()
        binding.cityWeatherRecycler.adapter = adapter

        mainActivityViewModel.error.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}