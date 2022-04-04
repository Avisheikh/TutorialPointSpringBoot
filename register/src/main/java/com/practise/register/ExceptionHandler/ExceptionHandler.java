package com.practise.register.ExceptionHandler;

import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.exception.EmailExistException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler{
    @org.springframework.web.bind.annotation.ExceptionHandler(value = EmailExistException.class)
    public ResponseEntity<Object> emailException(EmailExistException exp)
    {

        return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
