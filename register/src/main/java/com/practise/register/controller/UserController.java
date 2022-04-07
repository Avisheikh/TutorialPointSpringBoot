package com.practise.register.controller;

import com.practise.register.dto.*;
import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.model.TempUser;
import com.practise.register.service.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class UserController
{

    @Autowired
    private UserService userServiceInterface;

    // approve update data
    @RequestMapping(value = "/approve_update/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> approveUpdate(@PathVariable int id, String userName)
    {
        System.out.println(id);
        return userServiceInterface.updateUser(id,userName);

    }

    // Update data to temp user
    @RequestMapping(value = "/update_user/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> updateTempUser(@RequestBody TempUserRequest tempUserRequest, @PathVariable int id)
    {
        System.out.println(tempUserRequest.getEmail());
        return userServiceInterface.updateTempUser(id, tempUserRequest);
    }


    // approve user
    @RequestMapping(value = "/approve_user", method = RequestMethod.POST)
    public ResponseEntity<Object> approveUser(@RequestBody ApproveUserDto request, String userName)
    {
        System.out.println(request.getId());
        return userServiceInterface.saveUser(request.getId(),userName);
    }

    // get user data by id
    @RequestMapping(value = "/get_temp_user/{id}", method = RequestMethod.GET)
    public ResponseEntity<TempUserResponse> getTempUserById(@PathVariable int id)
    {
        return userServiceInterface.getTempUser(id);
    }

    // getting all temp user using temp dto url
    @RequestMapping(value = "/get_temp_user", method = RequestMethod.GET)
    public ResponseEntity<TempUserResponse> getAllTempUser()
    {
        return userServiceInterface.getAllTempUserDTO();
    }


    // create temp user url
    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public ResponseEntity<Object> createTempUserDTO(@Valid @RequestBody TempUserRequest tempUser)
    {
        return userServiceInterface.createTempUserDTO(tempUser);
    }

    // getting all temp user using temp no dto url
    @RequestMapping(value = "/get_temp", method = RequestMethod.GET)
    public List<TempUser> getAllTempUserNo()
    {
        List<TempUser> tempUsers = userServiceInterface.getAllTempUser();
        return tempUsers;
    }

    // login user
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest)
    {

        return userServiceInterface.loginUser(loginRequest);
    }




}
