package com.dalu.weatherreport.di

import com.dalu.weatherreport.ui.WeatherInfoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoryModule::class, UseCaseModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(weatherInfoActivity: WeatherInfoActivity)
}
