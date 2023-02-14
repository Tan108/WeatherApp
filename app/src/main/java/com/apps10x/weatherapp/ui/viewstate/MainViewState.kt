package com.apps10x.weatherapp.ui.viewstate

import com.apps10x.weatherapp.data.model.WeatherData
import com.apps10x.weatherapp.ui.viewmodel.RequiredData


sealed class MainViewState{
    object Idle : MainViewState()
    object Loading : MainViewState()
    class Error(val message:String) : MainViewState()
    class Success(val data:RequiredData): MainViewState()
}
