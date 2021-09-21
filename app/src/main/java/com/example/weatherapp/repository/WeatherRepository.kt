package com.example.weatherapp.repository

import com.example.weatherapp.models.OpenWeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val openWeatherApi: OpenWeatherApi) {
    suspend fun getWeather() = openWeatherApi.getWeatherLeszno()
}