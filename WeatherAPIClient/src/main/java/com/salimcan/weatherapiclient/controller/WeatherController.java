package com.salimcan.weatherapiclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.salimcan.weatherapiclient.entity.WeatherResponse;
import com.salimcan.weatherapiclient.entity.request.ForecastRequest;
import com.salimcan.weatherapiclient.entity.request.WeatherRequest;
import com.salimcan.weatherapiclient.service.WeatherServiceImpl;


@RestController
public class WeatherController {
	
	@Autowired
	private WeatherServiceImpl weatherService;
	
	
	@GetMapping("/weather")
	public ResponseEntity<WeatherResponse> getCurrentWeather(@RequestBody WeatherRequest request) throws JsonMappingException, JsonProcessingException {
		
		WeatherResponse weather = weatherService.getCurrentWeather(request.getCity());
		return new ResponseEntity<>(weather, HttpStatus.OK);
	}
	
	@GetMapping("/forecast")
	public ResponseEntity<WeatherResponse> getForecast(@RequestBody ForecastRequest request) throws JsonMappingException, JsonProcessingException {
		
		WeatherResponse weather = weatherService.getForecast(request.getCity(), request.getDay());
		return new ResponseEntity<>(weather, HttpStatus.OK);
	}

}
