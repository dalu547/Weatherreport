package com.dalu.weatherreport.network

import com.dalu.weatherreport.models.WeatherResponseDo
import com.dalu.weatherreport.core.utils.AppConstants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getWeatherReport(
        @Query("q") q: String = AppConstants.WEATHER_API_CITY,
        @Query("appid") appid: String = AppConstants.WEATHER_API_KEY
    ): Single<WeatherResponseDo?>
}