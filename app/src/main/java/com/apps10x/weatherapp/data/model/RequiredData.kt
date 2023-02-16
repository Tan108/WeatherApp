package com.apps10x.weatherapp.data.model

data class RequiredData(
    var temp: Double,
    val requiredForecastData: List<RequiredForecastData>
)

data class RequiredForecastData(
    val day:String,
    val temp:Double
)