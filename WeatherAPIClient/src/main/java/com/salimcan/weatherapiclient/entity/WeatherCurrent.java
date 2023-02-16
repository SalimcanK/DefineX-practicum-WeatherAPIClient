package com.salimcan.weatherapiclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherCurrent {
	
	@JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("temp_c")
    private double temperature;
    @JsonProperty("condition")
    private WeatherCondition condition;
    @JsonProperty("wind_kph")
    private double windSpeed;
    @JsonProperty("wind_dir")
    private String windDirection;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("cloud")
    private int cloud;
    @JsonProperty("feelslike_c")
    private double temperatureFeelsLike;
    
    
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public WeatherCondition getCondition() {
		return condition;
	}
	public void setCondition(WeatherCondition condition) {
		this.condition = condition;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getCloud() {
		return cloud;
	}
	public void setCloud(int cloud) {
		this.cloud = cloud;
	}
	public double getTemperatureFeelsLike() {
		return temperatureFeelsLike;
	}
	public void setTemperatureFeelsLike(double temperatureFeelsLike) {
		this.temperatureFeelsLike = temperatureFeelsLike;
	}
    
    
	

}
