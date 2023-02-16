package com.salimcan.weatherapiclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
	
	@JsonProperty("location")
    private WeatherLocation location;
    @JsonProperty("current")
    private WeatherCurrent current;
    
    
	public WeatherLocation getLocation() {
		return location;
	}
	public void setLocation(WeatherLocation location) {
		this.location = location;
	}
	public WeatherCurrent getCurrent() {
		return current;
	}
	public void setCurrent(WeatherCurrent current) {
		this.current = current;
	}
    

}
