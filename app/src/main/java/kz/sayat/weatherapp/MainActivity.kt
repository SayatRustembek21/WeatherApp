package kz.sayat.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kz.sayat.weatherapp.databinding.ActivityMainBinding
import kz.sayat.weatherapp.ui.MainActivityViewModel
import kz.sayat.weatherapp.ui.WeatherListAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = WeatherListAdapter()
        binding.cityWeatherRecycler.adapter = adapter

        mainActivityViewModel.error.observe(this, {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        mainActivityViewModel.isLoading.observe(this, {
            it?.let {
                hideOrShowViewsByLoadingState(it)
            }
        })

        mainActivityViewModel.weatherList.observe(this, {
            it?.let {
                adapter.submitList(it)
            }
            hideOrShowEmptyListText(it.isNullOrEmpty())
        })

        mainActivityViewModel.scrollToTop.observe(this, {
            if (it) {
                binding.cityWeatherRecycler.smoothScrollToPosition(0)
            }
        })

        binding.searchBtn.setOnClickListener {
            val query = binding.cityNameEditText.text.toString().trim()
            if(query.isEmpty())return@setOnClickListener
            mainActivityViewModel.addWeatherByCityName(query)
        }
    }

    private fun hideOrShowViewsByLoadingState(isLoading: Boolean) {
        if (isLoading) {
            binding.searchBtn.visibility = View.INVISIBLE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.searchBtn.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun hideOrShowEmptyListText(show: Boolean) {
        binding.emptyView.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}