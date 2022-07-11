package com.dalu.weatherreport

import android.app.Application
import android.content.Context

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        var application: Application? = null
            private set
        val context: Context?
            get() {
                return application?.applicationContext
            }
    }
}