package com.dalu.weatherreport.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dalu.weatherreport.R
import com.dalu.weatherreport.databinding.ActivityWeatherinfoBinding
import com.dalu.weatherreport.di.DaggerAppComponent
import com.dalu.weatherreport.models.WeatherResponseDo
import com.dalu.weatherreport.core.utils.AppConstants
import com.dalu.weatherreport.core.utils.Utils.getTemInCelsius
import com.dalu.weatherreport.viewmodels.ViewModelFactory
import com.dalu.weatherreport.viewmodels.WeatherReportViewModel
import javax.inject.Inject


class WeatherInfoActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityWeatherinfoBinding

    private var weatherReportViewModel: WeatherReportViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        DaggerAppComponent.create().inject(this)
        weatherReportViewModel =
            ViewModelProvider(this, viewModelFactory)[WeatherReportViewModel::class.java]

        weatherReportViewModel?.handleWeatherReport?.observe(this) { response ->
            response?.let { updateUI(it) }
        }
        weatherReportViewModel?.handleError?.observe(this) {
            CommonDialogs.showAlert(this, it)
            showErrorUI()
        }
        weatherReportViewModel?.handleLoader?.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun updateUI(responseDo: WeatherResponseDo) {
        binding.cityName.text = responseDo.name
        binding.temperature.text = getString(R.string.temp, getTemInCelsius(responseDo.main?.temp))
        binding.weatherType.text = responseDo.weather.firstOrNull()?.description
        binding.temperatureLowAndHigh.text = getString(
            R.string.min_high,
            getTemInCelsius(responseDo.main?.tempMin),
            getTemInCelsius(responseDo.main?.tempMax)
        )
        val imageUrl =
            "${AppConstants.WEATHER_API_IMAGE_ENDPOINT}${responseDo.weather.firstOrNull()?.icon}.png"
        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(binding.weatherIcon)
    }

    private fun showErrorUI() {
        binding.weatherType.text = "Forecast data not available, Please try after sometime"
    }
}