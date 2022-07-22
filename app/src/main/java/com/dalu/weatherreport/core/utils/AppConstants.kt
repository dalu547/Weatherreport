package com.dalu.weatherreport.core.utils

import com.dalu.weatherreport.BuildConfig

object AppConstants {
    const val BASE_URL_RETROFIT_API: String = BuildConfig.SERVER_URL
    const val WEATHER_API_KEY: String = BuildConfig.WEATHER_API_KEY

    const val WEATHER_API_IMAGE_ENDPOINT = "https://openweathermap.org/img/wn/"
    const val WEATHER_API_CITY = "Hyderabad"

    //Add bitrise CI/CD setup.

}