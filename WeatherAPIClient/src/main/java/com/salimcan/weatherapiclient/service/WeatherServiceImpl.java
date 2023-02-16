package com.salimcan.weatherapiclient.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salimcan.weatherapiclient.entity.ErrorResponse;
import com.salimcan.weatherapiclient.entity.WeatherResponse;
import com.salimcan.weatherapiclient.exception.CityNotFound;
import com.salimcan.weatherapiclient.exception.InvalidAPIKey;
import com.salimcan.weatherapiclient.util.*;


@Service
public class WeatherServiceImpl implements WeatherService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Value("${weather.api.key}")
    private String apiKey;
	
	@Value("${weather.api.request.url:https://api.weatherapi.com/v1}")
    private String url;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Override
	public WeatherResponse getCurrentWeather(String city) throws JsonMappingException, JsonProcessingException {
		
		String uri = RequestMapper.getCurrentUriString(city, apiKey, 0, url, "current");
		httpHeaders.add("METHOD_NAME", "getCurrent");
		
		return sendWeatherRequest(uri, httpHeaders);
		
	}
	
	private WeatherResponse sendWeatherRequest(String uri, HttpHeaders headers) throws JsonMappingException, JsonProcessingException {
        
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        
		try {
            
			WeatherResponse mappedResponse = objectMapper.readValue(response.getBody(), WeatherResponse.class);
            return mappedResponse;
            
		} catch (JsonProcessingException e) {
			
			throw e;
		}
        
        
    }

	@Override
	public WeatherResponse getForecast(String city, Integer days) throws JsonMappingException, JsonProcessingException {
		
		String uri = RequestMapper.getCurrentUriString(city, apiKey, days, url, "forecast");
        httpHeaders.add("METHOD_NAME", "getForecast");
        
        return sendWeatherRequest(uri, httpHeaders);
	}
	
	
	// Exception Handling
	@Override
    public void checkResponse(ResponseEntity<?> response) throws JsonProcessingException {
        
		
		if(response.getStatusCode().value() == 200) return;
        
		ErrorResponse error = objectMapper.readValue(response.getBody().toString(), ErrorResponse.class);
        
		if(Stream.of(1002, 2006, 2007, 2008, 2009).anyMatch(i -> i == response.getStatusCode().value())) {
            
			System.out.println(error.getError().getMessage() + "API Key: " + apiKey);
            throw new InvalidAPIKey(error.getError().getMessage() + "API Key: " + apiKey);
            
        } else if (error.getError().getCode() == 1006) {
            
        	error.getError().getMessage();
            throw new CityNotFound(error.getError().getMessage());
        }
    }

}
