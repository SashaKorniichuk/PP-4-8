package com.example.Knights.Domain.Response;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private String message;

    private HttpStatus statusCode;

    public BaseResponse(String message,HttpStatus statusCode) {
        this.message = message;
        this.statusCode=statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

}
