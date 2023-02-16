package com.salimcan.weatherapiclient.entity.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class ForecastRequest {
	
	
	@Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    @NotBlank(message = "City cannot be empty!")
    String city;
    
	@Min(value = 1, message = "Day must be more than or equal to 1.")
    @Max(value = 14, message = "Day count must be less than or equal to 14.")
    @NotNull(message = "Day count cannot be null for forecast request.")
    Integer day;

	public String getCity() {
		return city;
	}

	public Integer getDay() {
		return day;
	}

}
