package com.example.weatherapp.models

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.Weather
import retrofit2.http.GET

interface OpenWeatherApi {
    @GET("weather?q=leszno&units=metric&appid=" + BuildConfig.ApiKey)
    suspend fun getWeatherLeszno(
    ): Weather
}