package com.apps10x.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps10x.weatherapp.data.model.ForecastData
import com.apps10x.weatherapp.data.model.WeatherData
import com.apps10x.weatherapp.data.repository.MainRepository
import com.apps10x.weatherapp.helper.MainHelper
import com.apps10x.weatherapp.ui.viewstate.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

//    private val _state = MutableLiveData<MainViewState>(MainViewState.Idle)

    @Inject
    lateinit var mainHelper: MainHelper

    fun getWeatherAndForecastData() : MutableLiveData<MainViewState>{
        val state = MutableLiveData<MainViewState>(MainViewState.Idle)
        viewModelScope.launch {
            state.value = MainViewState.Loading
            try{
                state.value = MainViewState.Success(data = RequiredData(mainRepository.getWeather().main.temp,
                mainHelper.handleForeCastData(mainRepository.getForecast())))
            }catch (e: Exception){
                state.value = MainViewState.Error(message = e.message.toString())
            }
        }
        return state
    }


}

data class RequiredData(
    var temp: Double,
    val requiredForecastData: List<RequiredForecastData>
)

data class RequiredForecastData(
    val day:String,
    val temp:Double
)



