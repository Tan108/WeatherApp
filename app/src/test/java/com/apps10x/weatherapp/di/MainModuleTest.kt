package com.apps10x.weatherapp.di

import com.apps10x.weatherapp.data.api.ApiService
import dagger.Module
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainModuleTest {

     private var apiService:ApiService = MainModule.provideApiService()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun provideApiService() {
        assertNotNull(apiService)
    }

    @Test
    fun provideMainRepository() {
        assertNotNull(MainModule.provideMainRepository(apiService))
    }

    @Test
    fun provideMainHelper() {
        assertNotNull(MainModule.provideMainHelper())
    }
}