package com.practise.register.serviceInterface;

import com.practise.register.model.TempUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserServiceInterface
{
    ResponseEntity<Object> createTempUser(TempUser requestTempUser);
}
