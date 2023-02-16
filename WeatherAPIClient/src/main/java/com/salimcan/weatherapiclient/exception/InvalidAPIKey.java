package com.salimcan.weatherapiclient.exception;


public class InvalidAPIKey extends IllegalArgumentException {
    
	private static final String GENERIC_MESSAGE = "Wrong API key!";

    public InvalidAPIKey(String s) {
        super(GENERIC_MESSAGE + " " + s);
    }
}