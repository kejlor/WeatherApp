package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.Weather
import com.example.weatherapp.module.WeatherAppModule.retrofit
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val myResponse: MutableLiveData<Weather> = MutableLiveData()

    fun getWeather() {
        viewModelScope.launch {
            myResponse.value = retrofit.getWeatherLeszno()
        }
    }
}