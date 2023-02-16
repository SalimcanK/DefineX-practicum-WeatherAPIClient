package com.salimcan.weatherapiclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
	
	
	 @JsonProperty("error")
	 Error error;
	 
	  
	 public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	
	public class Error {
		 
		 @JsonProperty("code")
	     Integer code;
		 
	     @JsonProperty("message")
	     String message;

		
	     public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	     
	     
	 }

}
