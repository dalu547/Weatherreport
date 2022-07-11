package com.dalu.weatherreport.di

import com.dalu.weatherreport.repositories.WeatherRepository
import com.dalu.weatherreport.usecases.GetWeatherReportUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun providesWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherReportUseCase {
        return GetWeatherReportUseCase(weatherRepository)
    }
}