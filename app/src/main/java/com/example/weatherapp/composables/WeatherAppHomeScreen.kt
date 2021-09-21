package com.example.weatherapp.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun WeatherAppHomeScreen() {
    val weather by remember { mutableStateOf("") }
    Row() {
        Text(text = weather)
    }
}