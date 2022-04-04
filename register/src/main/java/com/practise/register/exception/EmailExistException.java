package com.practise.register.exception;

import org.springframework.http.HttpStatus;

public class EmailExistException extends RuntimeException
{
    private String message;

    public EmailExistException(String message) {
        super(message);
        this.message=message;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
