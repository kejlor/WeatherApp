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
            Text(text = "Checking weather for " + weather.name + ":")
            Text(text = "Temperature: " + weather.main.temp.toString() + "\u00B0")
            Text(text = "Sky: " + weather.weather[0].description)
            Text(text = "Max temperature: " + weather.main.tempMax.toString() + "\u00B0")
            Text(text = "Min temperature: " +weather.main.tempMin.toString() + "\u00B0")
            Text(text = "Wind speed: " + weather.wind.speed.toString() + " km/h")
        }
    }
}