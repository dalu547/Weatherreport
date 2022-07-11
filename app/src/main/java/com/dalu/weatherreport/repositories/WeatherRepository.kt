package com.dalu.weatherreport.repositories

import com.dalu.weatherreport.models.WeatherResponseDo
import com.dalu.weatherreport.network.WeatherApi
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApis: WeatherApi) {
    fun getWeatherReport(): Single<WeatherResponseDo?> {
        return weatherApis.getWeatherReport()
    }

}