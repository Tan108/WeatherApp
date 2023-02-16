package com.apps10x.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps10x.weatherapp.R
import com.apps10x.weatherapp.data.model.Main
import com.apps10x.weatherapp.databinding.ActivityMainBinding
import com.apps10x.weatherapp.ui.adapter.MainAdapter
import com.apps10x.weatherapp.ui.viewmodel.MainViewModel
import com.apps10x.weatherapp.ui.viewstate.MainViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainBinding.rvForecast.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        mainBinding.btnRetry.setOnClickListener {
            handleObserver()
        }
        handleObserver()
    }

    private fun handleObserver(){
        mainViewModel.getWeatherAndForecastData().observe(this){
            when(it){
                is MainViewState.Loading -> {
                    mainBinding.llProgressLayout.visibility = View.VISIBLE
                }
                is MainViewState.Success -> {
                    mainBinding.temperature = it.data.temp.toString()  + getString(R.string.super_script_o)
                    mainBinding.adapter = MainAdapter(it.data.requiredForecastData)
                    mainBinding.llMainLayout.visibility = View.VISIBLE

                }
                is MainViewState.Error -> {
                    mainBinding.llErrorLayout.visibility = View.VISIBLE
                }
            }
        }
    }
}