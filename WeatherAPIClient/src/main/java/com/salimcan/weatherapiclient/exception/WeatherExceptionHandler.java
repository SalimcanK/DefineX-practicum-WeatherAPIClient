package com.salimcan.weatherapiclient.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestControllerAdvice
public class WeatherExceptionHandler {

	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	
	@ExceptionHandler({InvalidAPIKey.class})
    private ResponseEntity<Map<String, String>> handleAPIException(InvalidAPIKey e) {
        
		Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        
        try {
            objectMapper.writeValueAsString(error);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
	
	@ExceptionHandler({CityNotFound.class})
    private ResponseEntity<Map<String, String>> handCityNotFoundException(CityNotFound e) {
        
		Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        try {
           objectMapper.writeValueAsString(error);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
