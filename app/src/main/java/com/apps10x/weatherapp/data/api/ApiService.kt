package com.apps10x.weatherapp.data.api

import com.apps10x.weatherapp.data.model.ForecastData
import com.apps10x.weatherapp.data.model.WeatherData

import retrofit2.http.GET

interface ApiService {

    @GET("weather?q=Bengaluru&APPID=9b8cb8c7f11c077f8c4e217974d9ee40&units=metric")
    suspend fun getWeather(): WeatherData

    @GET("forecast?q=bengaluru&APPID=9b8cb8c7f11c077f8c4e217974d9ee40&units=metric")
    suspend fun getForecast(): ForecastData

}