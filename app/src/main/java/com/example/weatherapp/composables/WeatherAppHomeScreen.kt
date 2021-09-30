package com.example.weatherapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.Weather
import com.example.weatherapp.ui.theme.SkyBlue
import com.example.weatherapp.viewmodel.WeatherViewModel


@Composable
fun WeatherAppHomeScreen(weatherViewModel: WeatherViewModel) {
    val weatherState: State<Weather?> = weatherViewModel.myResponse.observeAsState()
    val weather: Weather? = weatherState.value
    if (weather != null) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = SkyBlue
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp)
            ) {
                if (weather.main.temp < 0) {
                    Icon(painter = painterResource(id = R.drawable._01lighticons_07), contentDescription = "", tint = Color.White)
                } else {
                    Icon(painter = painterResource(id = R.drawable._01lighticons_02), contentDescription = "", tint = Color.Yellow)
                }
                Text(text = stringResource(id = R.string.checking_weather_for) + weather.name + ":")
                Divider()
                Text(text = stringResource(id = R.string.temperature) + weather.main.temp.toString() + "\u00B0")
                Divider()
                Text(text = stringResource(id = R.string.sky) + weather.weather[0].description)
                Divider()
                Text(text = stringResource(id = R.string.max_temp) + weather.main.tempMax.toString() + "\u00B0")
                Divider()
                Text(text = stringResource(id = R.string.min_temp) + weather.main.tempMin.toString() + "\u00B0")
                Divider()
                Text(text = stringResource(id = R.string.wind_speed) + weather.wind.speed.toString() + " km/h")
            }
        }
    }
}