package com.example.weatherapp.module

import com.example.weatherapp.models.OpenWeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherAppModule {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(OpenWeatherApi::class.java)
    }
}