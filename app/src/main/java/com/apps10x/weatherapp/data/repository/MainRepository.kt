package com.apps10x.weatherapp.data.repository

import com.apps10x.weatherapp.data.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private var apiService: ApiService) {

    suspend fun getWeather() = apiService.getWeather()

    suspend fun getForecast() = apiService.getForecast()

}