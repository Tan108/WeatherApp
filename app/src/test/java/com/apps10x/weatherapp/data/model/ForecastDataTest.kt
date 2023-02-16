package com.apps10x.weatherapp.data.model

import org.junit.Assert.*

import org.junit.Test

class ForecastDataTest {

    val coord = Coord(12.9762,77.6033)
    val city = City(1277333,"Bengaluru",coord,"IN",5104047,19800,1676423546,1676465719)
    val main = Main(294.95,294.39,292.72,294.95,1017,1017)
    val weather = Weather(800,"Clear","clear sky","01n")
    val wind = Wind(4.27,95)
    val clouds=Clouds(0)
    val sys = Sys(0,0,"IN",0,0)
    val mainClass = MainClass(293.59,293.02,290.87,293.59,1016,1016,910,51,2.72)
    val listElement = ListElement(1676484000, mainClass, listOf(weather), clouds,wind,10000,0,sys,"2023-02-15 18:00:00")
    val forecastData = ForecastData("200",0,40,listOf(listElement),city)

    @Test
    fun getForecastData() {
        assertNotNull(forecastData)
        assertEquals(forecastData.city,city)
        assertEquals(forecastData.cod,"200")
        assertEquals(forecastData.message,0)
        assertEquals(forecastData.cnt,40)
        assertEquals(forecastData.list, listOf(listElement))
    }

    @Test
    fun getCoord() {
        assertNotNull(coord)
        assertNotNull(coord.lat)
        assertNotNull(coord.lon)
    }

    @Test
    fun getCity() {
        assertNotNull(city)
        assertEquals(city.id,1277333)
        assertEquals(city.name,"Bengaluru")
        assertEquals(city.coord,coord)
        assertEquals(city.country,"IN")
    }

    @Test
    fun getClouds() {
        assertNotNull(clouds)
        assertEquals(clouds.all,0)
    }

    @Test
    fun getMainClass(){
        assertNotNull(mainClass)
        assertEquals(mainClass.pressure,1016)
        assertEquals(mainClass.seaLevel,1016)
        assertEquals(mainClass.humidity,51)
        assertEquals(mainClass.grndLevel,910)
    }

    @Test
    fun getSys(){
        assertNotNull(sys)
        assertEquals(sys.id,0)
        assertEquals(sys.country,"IN")
        assertEquals(sys.type,0)
        assertEquals(sys.sunrise,0)
        assertEquals(sys.sunset,0)
    }

    @Test
    fun getListElement(){
        assertNotNull(listElement)
        assertEquals(listElement.pop,0)
        assertEquals(listElement.sys,sys)
        assertEquals(listElement.clouds,clouds)
    }

}