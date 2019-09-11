/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.exceptions;

import java.sql.Timestamp;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Jovana Mitrovic
 */
public class ApiException {
    private String message;
    private HttpStatus httpStatus;
    private Timestamp timestamp;
    private Throwable throwable;

    public ApiException() {
    }

    public ApiException(String message, HttpStatus httpStatus, Timestamp timestamp, Throwable throwable) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
    
    
}
