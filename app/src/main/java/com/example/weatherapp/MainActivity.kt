package com.example.weatherapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.composables.WeatherAppHomeScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
            weatherViewModel.getWeather()
            weatherViewModel.myResponse.observe(this, Observer {
                Log.d(TAG, it.main.temp.toString())
                Log.d(TAG, it.main.pressure.toString())
            }
            )
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WeatherAppHomeScreen(weatherViewModel)
                }
            }
        }
    }
}