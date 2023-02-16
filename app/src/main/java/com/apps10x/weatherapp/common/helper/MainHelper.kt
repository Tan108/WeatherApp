package com.apps10x.weatherapp.common.helper

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.apps10x.weatherapp.common.constant.AppConstant
import com.apps10x.weatherapp.data.model.ForecastData
import com.apps10x.weatherapp.data.model.RequiredForecastData
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
        var abc = AppConstant.NUMBER_ZERO_POINT_ZERO
        var counter = AppConstant.NUMERIC_ZERO
        abc += temp
        counter ++
        return abc/counter
    }

    private fun calculateAverageTemp(requiredForecastDataList: List<RequiredForecastData>):HashMap<String,Double>{
        val map = LinkedHashMap<String,Double>()
        for (data in requiredForecastDataList){
            if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(AppConstant.NUMERIC_ONE)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(AppConstant.NUMERIC_TWO)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(AppConstant.NUMERIC_THREE)),true)){
                map[data.day] = findAverage(data.temp)
            }else if(data.day.equals(getDayFromDateFormat(getNextDayWithDayCounter(AppConstant.NUMERIC_FOUR)),true)){
                map[data.day] = findAverage(data.temp)
            }
        }
        return map
    }

    @SuppressLint("SimpleDateFormat")
    fun getNextDayWithDayCounter(dayCounter : Int) : String{
        val sdf = SimpleDateFormat(AppConstant.PATTERN_yyyy_MM_dd)
        return sdf.format(Date(Date().time + AppConstant.NO_OF_SECONDS_IN_A_DAY * dayCounter))

    }

    private fun isDateAvailable(date:String):Boolean{
        return date.contains(getNextDayWithDayCounter(1))
                || date.contains(getNextDayWithDayCounter(2))
                || date.contains(getNextDayWithDayCounter(3))
                || date.contains(getNextDayWithDayCounter(4))

    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDateWithTimeFormat(date: String):String{
        val format1 = SimpleDateFormat(AppConstant.PATTEERN_yyyy_MM_dd_HH_mm_ss)
        val format2 = SimpleDateFormat(AppConstant.PATTERN_EEEE)
        return format2.format(format1.parse(date)!!)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayFromDateFormat(date: String):String{
        val formatDate = SimpleDateFormat(AppConstant.PATTERN_yyyy_MM_dd)
        val formatDay = SimpleDateFormat(AppConstant.PATTERN_EEEE)
        return formatDay.format(formatDate.parse(date)!!)
    }

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                //It will check for both wifi and cellular network
                return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            }
            return false
        } else {
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
    }
}

