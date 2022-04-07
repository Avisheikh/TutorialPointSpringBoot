package com.practise.register.service;

import com.practise.register.dto.LoginRequest;
import com.practise.register.dto.TempUserDto;
import com.practise.register.dto.TempUserRequest;
import com.practise.register.dto.TempUserResponse;
import com.practise.register.model.TempUser;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService
{
    List<TempUser> getAllTempUser();

    ResponseEntity<TempUserResponse> getAllTempUserDTO();

    ResponseEntity<Object> createTempUserDTO(TempUserRequest requestTempUser);

    ResponseEntity<Object> saveUser(int id, String userName);

    ResponseEntity<Object> updateTempUser(int id, TempUserRequest tempUserRequest);

    ResponseEntity<Object> updateUser(int id, String userName);

    ResponseEntity<TempUserResponse> getTempUser(int id);

    ResponseEntity<Object> loginUser(LoginRequest loginRequest);

}
