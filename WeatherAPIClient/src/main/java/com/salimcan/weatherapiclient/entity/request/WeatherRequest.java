package com.salimcan.weatherapiclient.entity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class WeatherRequest {
	
	@Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    @NotBlank
    String city;

	
	public String getCity() {
		return city;
	}
	

}
