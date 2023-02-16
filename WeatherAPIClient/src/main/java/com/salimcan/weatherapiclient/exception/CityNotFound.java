package com.salimcan.weatherapiclient.exception;


public class CityNotFound extends IllegalArgumentException {
    
	private static final String GENERIC_MESSAGE = "Provided city is not found!";

    public CityNotFound(String s) {
        super(s);
    }
}