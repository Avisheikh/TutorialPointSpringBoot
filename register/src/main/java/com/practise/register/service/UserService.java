package com.practise.register.service;

import com.practise.register.dto.*;
import com.practise.register.model.Authentication;
import com.practise.register.model.TempUser;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService
{
    List<TempUser> getAllTempUser();

    ResponseEntity<TempUserResponse> getAllTempUserDTO();

    ResponseEntity<Object> createTempUserDTO(TempUserRequest requestTempUser);

    ResponseEntity<UserResponse> getUserByID(int id);

    ResponseEntity<Object> saveUser(int id, String userName);

    ResponseEntity<Object> updateTempUser(int id, TempUserRequest tempUserRequest);

    ResponseEntity<Object> updateUser(int id, String userName);

    ResponseEntity<UserResponse> listUser();

    ResponseEntity<TempUserResponse> getTempUser(int id);

    ResponseEntity<Object> loginUser(LoginRequest loginRequest);

    ResponseEntity<Object> logout();

    ResponseEntity<Object> modifyUser(ModifyUserRequest modifyUserRequest, int id);

    ResponseEntity<ModifyUserResponse> getModifyUser();

    ResponseEntity<Object> modifyUserByID(int id);

    ResponseEntity<Object> saveModifyUser(int id);
}
