package com.apps10x.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps10x.weatherapp.databinding.ItemForecastBinding
import com.apps10x.weatherapp.helper.MainHelper
import com.apps10x.weatherapp.ui.viewmodel.RequiredData
import com.apps10x.weatherapp.ui.viewmodel.RequiredForecastData
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.time.days


class MainAdapter(private val list: List<RequiredForecastData>) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    inner class MyViewHolder(val itemForecastBinding: ItemForecastBinding) : RecyclerView.ViewHolder(itemForecastBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
       val binding = ItemForecastBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        val binding = holder.itemForecastBinding
        binding.day = list[position].day
        binding.temperature = list[position].temp.toString() + "C"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}