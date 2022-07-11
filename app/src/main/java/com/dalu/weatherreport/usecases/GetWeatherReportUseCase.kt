package com.dalu.weatherreport.usecases

import com.dalu.weatherreport.models.WeatherResponseDo
import com.dalu.weatherreport.repositories.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class GetWeatherReportUseCase @Inject constructor(private val weatherRepository: WeatherRepository) :
    BaseUseCase.NoParamUseCase<WeatherResponseDo?> {
    override fun getAction(): Single<WeatherResponseDo?> {
        return weatherRepository.getWeatherReport()
    }
}