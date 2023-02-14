package com.apps10x.weatherapp.helper

import android.annotation.SuppressLint
import com.apps10x.weatherapp.data.model.ForecastData
import com.apps10x.weatherapp.ui.viewmodel.RequiredForecastData
import java.text.SimpleDateFormat
import java.util.*

class MainHelper {

    fun handleForeCastData(forecastData: ForecastData): List<RequiredForecastData> {
        val tempList: MutableList<RequiredForecastData> = mutableListOf()
        for (value in forecastData.list){
            if(isDateAvailable(value.dtTxt)){
                tempList.add(RequiredForecastData(getDayFromDateWithTimeFormat(value.dtTxt),value.main.temp))
            }
        }

        return calculateAverageTemp(tempList)
            .toList()
            .map { RequiredForecastData(it.first,it.second) }
    }

    private fun findAverage(temp:Double):Double{
        var abc = 0.0
        var counter = 0
        abc += temp
        counter ++
        return abc/counter
    }

    private fun calculateAverageTemp(requiredForecastDataList: List<RequiredForecastData>):HashMap<String,Double>{
        val map = LinkedHashMap<String,Double>()
        for (data in requiredForecastDataList){
            if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(1)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(2)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(3)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(4)),true)){
                map[data.day] = findAverage(data.temp)
            }
        }
        return map
    }

    @SuppressLint("SimpleDateFormat")
    fun getNextDayWithDayCounter(dayCounter : Int) : String{
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(Date(Date().time + 1000 * 60 * 60 * 24 * dayCounter))

    }

    private fun isDateAvailable(date:String):Boolean{
        return date.contains(getNextDayWithDayCounter(1))
                || date.contains(getNextDayWithDayCounter(2))
                || date.contains(getNextDayWithDayCounter(3))
                || date.contains(getNextDayWithDayCounter(4))

    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDateWithTimeFormat(date: String):String{
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val format2 = SimpleDateFormat("EEEE")
        return format2.format(format1.parse(date)!!)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDateFormat(date: String):String{
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        val formatDay = SimpleDateFormat("EEEE")
        return formatDay.format(formatDate.parse(date)!!)
    }

}

