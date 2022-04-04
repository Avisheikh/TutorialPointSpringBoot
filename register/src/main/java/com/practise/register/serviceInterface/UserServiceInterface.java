package com.practise.register.serviceInterface;

import com.practise.register.dto.TempUserDTO;
import com.practise.register.dto.TempUserRequest;
import com.practise.register.model.TempUser;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UserServiceInterface
{
    List<TempUser> getAllTempUser();

    List<TempUserDTO> getAllTempUserDTO();

    ResponseEntity<Object> createTempUserDTO(TempUserRequest requestTempUser);

    ResponseEntity<Object> saveUser(int id, String userName);

    ResponseEntity<Object> updateTempUser(int id, TempUserRequest tempUserRequest);

    ResponseEntity<Object> updateUser(int id, String userName);
}
