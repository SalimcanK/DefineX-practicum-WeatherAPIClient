package com.salimcan.weatherapiclient.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.salimcan.weatherapiclient.entity.WeatherResponse;


public interface WeatherService {
	
    WeatherResponse getCurrentWeather(String city) throws JsonMappingException, JsonProcessingException;

    WeatherResponse getForecast(String city, Integer days) throws JsonMappingException, JsonProcessingException;
    
    void checkResponse(ResponseEntity<?> response) throws JsonProcessingException;

}
