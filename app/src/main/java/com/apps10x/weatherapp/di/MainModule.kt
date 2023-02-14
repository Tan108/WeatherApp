package com.apps10x.weatherapp.di

import com.apps10x.weatherapp.data.api.ApiService
import com.apps10x.weatherapp.data.repository.MainRepository
import com.apps10x.weatherapp.helper.MainHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideApiService(): ApiService{
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideMainRepository(apiService: ApiService):MainRepository{
        return MainRepository(apiService)
    }

    @Provides
    fun provideMainHelper() = MainHelper()

}