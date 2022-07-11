package com.dalu.weatherreport.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dalu.weatherreport.R
import com.dalu.weatherreport.WeatherApplication
import com.dalu.weatherreport.models.WeatherResponseDo
import com.dalu.weatherreport.usecases.GetWeatherReportUseCase
import com.dalu.weatherreport.core.utils.NetworkUtils
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherReportViewModel @Inject constructor(private val weatherReportUseCase: GetWeatherReportUseCase) :
    ViewModel() {

    private val mWeatherReport = MutableLiveData<WeatherResponseDo>()
    val handleWeatherReport: LiveData<WeatherResponseDo> get() = mWeatherReport

    private val mError = MutableLiveData<String>()
    val handleError: LiveData<String> get() = mError

    private val mLoader = MutableLiveData<Boolean>()
    val handleLoader: LiveData<Boolean> get() = mLoader

    init {
        getWeatherReport()
    }

    private fun getWeatherReport() {
        if (!NetworkUtils.isNetworkAvailable()) {
            mLoader.postValue(false)
            mError.postValue(WeatherApplication.context?.getString(R.string.no_network_message))
            return
        }
        mLoader.postValue(true)
        weatherReportUseCase.getAction().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<WeatherResponseDo?> {
                override fun onSuccess(response: WeatherResponseDo) {
                    mLoader.postValue(false)
                    mWeatherReport.postValue(response)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onError(ex: Throwable) {
                    mLoader.postValue(false)
                    mError.postValue(WeatherApplication.context?.getString(R.string.service_not_available))
                }
            })
    }
}