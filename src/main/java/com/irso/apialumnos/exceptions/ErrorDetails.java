package com.irso.apialumnos.exceptions;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
    private String message;   
    private String url;

    public ErrorDetails(Date timestamp, String message, String url) {
         super();
         this.timestamp = timestamp;
         this.message = message;
         this.url = url;
    }

    public Date getTimestamp() {
         return timestamp;
    }
    

    public String getMessage() {
         return message;
    }
    
    public String getUrl() {
         return url;
    }

	

}
