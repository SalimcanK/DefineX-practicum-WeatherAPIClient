package com.salimcan.weatherapiclient.service;

import com.salimcan.weatherapiclient.entity.WeatherResponse;


public interface WeatherService {
	
    WeatherResponse getCurrentWeather(String city);

    WeatherResponse getForecast(String city, Integer days);

}
