package com.dalu.weatherreport

import com.dalu.weatherreport.core.utils.AppConstants
import com.dalu.weatherreport.network.WeatherApi
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.system.measureTimeMillis

class WeatherViewModelTestClass {
    var services: WeatherApi? = null

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL_RETROFIT_API)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        services = retrofit.create(WeatherApi::class.java)
    }

    @Test
    fun testStatesApiTest() {
        var time: Long?
        runBlocking {
            time = measureTimeMillis {
                val responseDo = services?.getWeatherReport()
                println("temperature: ${responseDo?.blockingGet()?.main?.temp}")
                Assert.assertEquals(true, responseDo?.blockingGet()?.cod ?: 0 == 200)
            }
        }
        println("Time taken: $time")
    }
}