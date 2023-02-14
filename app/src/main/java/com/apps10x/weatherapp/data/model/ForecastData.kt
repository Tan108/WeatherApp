package com.apps10x.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class ForecastData(
    val cod: String,
    val message: Long,
    val cnt: Long,
    val list: List<ListElement>,
    val city: City
)

data class City (
    val id: Long,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Long,
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long
)

/*
data class Coord (
    val lat: Double,
    val lon: Double
)
*/

data class ListElement (
    val dt: Long,
    val main: MainClass,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Long,
    val pop: Long,
    val sys: Sys,

    @SerializedName("dt_txt")
    val dtTxt: String
)

/*data class Clouds (
    val all: Long
)*/

data class MainClass (
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("temp_max")
    val tempMax: Double,

    val pressure: Long,

    @SerializedName("sea_level")
    val seaLevel: Long,

    @SerializedName("grnd_level")
    val grndLevel: Long,

    val humidity: Long,

    @SerializedName("temp_kf")
    val tempKf: Double
)

/*data class Sys (
    val pod: Pod
)

data class Weather (
    val id: Long,
    val main: MainEnum,
    val description: Description,
    val icon: String
)

data class Wind (
    val speed: Double,
    val deg: Long,
    val gust: Double
)*/

enum class Pod(val value: String) {
    D("d"),
    N("n");
}

enum class Description(val value: String) {
    BrokenClouds("broken clouds"),
    ClearSky("clear sky"),
    FewClouds("few clouds"),
    ScatteredClouds("scattered clouds");
}

enum class MainEnum(val value: String) {
    Clear("Clear"),
    Clouds("Clouds");
}
