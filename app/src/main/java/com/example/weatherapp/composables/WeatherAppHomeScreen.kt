package com.example.weatherapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.example.weatherapp.data.Weather
import com.example.weatherapp.viewmodel.WeatherViewModel


@Composable
fun WeatherAppHomeScreen(weatherViewModel: WeatherViewModel) {
    val weatherState: State<Weather?> = weatherViewModel.myResponse.observeAsState()
    val weather: Weather? = weatherState.value
    if (weather != null) {
        Column() {
            Text(text = weather.main.temp.toString())
            Text(text = weather.wind.speed.toString())
            Text(text = weather.main.tempMax.toString())
            Text(text = weather.main.tempMin.toString())
            Text(text = weather.weather[0].description)
        }
    }
}