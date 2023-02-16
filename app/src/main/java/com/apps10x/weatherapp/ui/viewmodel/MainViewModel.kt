package com.apps10x.weatherapp.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps10x.weatherapp.R
import com.apps10x.weatherapp.data.repository.MainRepository
import com.apps10x.weatherapp.common.helper.MainHelper
import com.apps10x.weatherapp.data.model.RequiredData
import com.apps10x.weatherapp.ui.viewstate.MainViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext  val context: Context, private val mainRepository: MainRepository) : ViewModel() {

    @Inject
    lateinit var mainHelper: MainHelper

    fun getWeatherAndForecastData() : MutableLiveData<MainViewState>{
        val state = MutableLiveData<MainViewState>(MainViewState.Idle)
        viewModelScope.launch {
            state.value = MainViewState.Loading
            if (mainHelper.isOnline(context)){
                try{
                    state.value = MainViewState.Success(data = RequiredData(
                        mainRepository.getWeather().main.temp,
                        mainHelper.handleForeCastData(mainRepository.getForecast())
                        )
                    )
                }catch (e: Exception){
                    state.value = MainViewState.Error(message = e.message.toString())
                }
            }else{
                Toast.makeText(context,context.getString(R.string.please_check_your_network_status),Toast.LENGTH_LONG).show()
                state.value = MainViewState.Error(message = context.getString(R.string.network_not_available))
            }
        }
        return state
    }
}




