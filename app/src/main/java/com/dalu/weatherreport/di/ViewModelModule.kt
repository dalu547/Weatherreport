package com.dalu.weatherreport.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dalu.weatherreport.viewmodels.ViewModelFactory
import com.dalu.weatherreport.viewmodels.WeatherReportViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }

    @Provides
    @IntoMap
    @ViewModelKey(WeatherReportViewModel::class)
    fun weatherReportViewModel(viewModel: WeatherReportViewModel): ViewModel {
        return viewModel
    }
}