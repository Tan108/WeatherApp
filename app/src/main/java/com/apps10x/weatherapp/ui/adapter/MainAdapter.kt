package com.apps10x.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps10x.weatherapp.common.constant.AppConstant
import com.apps10x.weatherapp.data.model.RequiredForecastData
import com.apps10x.weatherapp.databinding.ItemForecastBinding

class MainAdapter(private val list: List<RequiredForecastData>) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    inner class MyViewHolder(val itemForecastBinding: ItemForecastBinding) : RecyclerView.ViewHolder(itemForecastBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
       val binding = ItemForecastBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        val binding = holder.itemForecastBinding
        binding.day = list[position].day
        binding.temperature = list[position].temp.toString() + AppConstant.C
    }

    override fun getItemCount(): Int {
        return list.size
    }
}