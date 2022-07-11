package com.dalu.weatherreport.core.utils

import kotlin.math.roundToInt

object Utils {
    fun getTemInCelsius(kelvinValue: Double?): Int {
        return ((kelvinValue ?: 0).toFloat() - 273.15).roundToInt()
    }
}