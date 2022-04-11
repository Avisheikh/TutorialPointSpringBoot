package com.practise.register.controller;

import com.practise.register.constants.PathConstant;
import com.practise.register.dto.*;
import com.practise.register.model.TempUser;
import com.practise.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class UserController
{

    @Autowired
    private UserService userServiceInterface;


    // login user
    @RequestMapping(value = PathConstant.login, method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest)
    {
        return userServiceInterface.loginUser(loginRequest);
    }

    // sign out user
    @RequestMapping(value = PathConstant.logout, method = RequestMethod.GET)
    public ResponseEntity<Object> signOut()
    {
        return userServiceInterface.logout();
    }

    // create temp user url
    @RequestMapping(value = PathConstant.createUser, method = RequestMethod.POST)
    public ResponseEntity<Object> createTempUserDTO(@Valid @RequestBody TempUserRequest tempUser)
    {
        return userServiceInterface.createTempUserDTO(tempUser);
    }

    // getting all temp user using temp dto url
    @RequestMapping(value = PathConstant.listTempUser, method = RequestMethod.GET)
    public ResponseEntity<TempUserResponse> getAllTempUser()
    {
        return userServiceInterface.getAllTempUserDTO();
    }

    // get user data by id
    @RequestMapping(value = PathConstant.getTempUserById, method = RequestMethod.GET)
    public ResponseEntity<TempUserResponse> getTempUserById(@PathVariable int id)
    {
        return userServiceInterface.getTempUser(id);
    }

    // approve user
    @RequestMapping(value = PathConstant.approveUser, method = RequestMethod.POST)
    public ResponseEntity<Object> approveUser(@RequestBody ApproveUserDto request, String userName)
    {
        return userServiceInterface.saveUser(request.getId(),userName);
    }

    // get user list
    @RequestMapping(value = PathConstant.listUser, method = RequestMethod.GET)
    public ResponseEntity<UserResponse> listUser()
    {
        return userServiceInterface.listUser();
    }

    @RequestMapping(value = PathConstant.getUser, method = RequestMethod.GET)
    public ResponseEntity<UserResponse> getUser(@PathVariable int id)
    {
        return userServiceInterface.getUserByID(id);
    }


    // Update data to temp user
    @RequestMapping(value = PathConstant.updateTempUser, method = RequestMethod.POST)
    public ResponseEntity<Object> updateTempUser(@RequestBody TempUserRequest tempUserRequest, @PathVariable int id)
    {
        return userServiceInterface.updateTempUser(id, tempUserRequest);
    }

    // Save to modify table
    @RequestMapping(value = PathConstant.createModifyUser, method = RequestMethod.POST)
    public ResponseEntity<Object> createModifyUser(@RequestBody ModifyUserRequest modifyUserRequest,@PathVariable int id)
    {
        return userServiceInterface.modifyUser(modifyUserRequest, id);
    }

    // get all modify user list
    @RequestMapping(value = PathConstant.listModifyUser, method = RequestMethod.GET)
    public ResponseEntity<ModifyUserResponse> modifyUserList()
    {
        return userServiceInterface.getModifyUser();
    }

    // get detail view of modify user by id
    @RequestMapping(value = PathConstant.getModifyUserById, method = RequestMethod.GET)
    public ResponseEntity<Object> getModifyUserByID(@PathVariable int id)
    {
        return userServiceInterface.modifyUserByID(id);
    }

    // approve update user
    @RequestMapping(value = PathConstant.approveModifyUser, method = RequestMethod.GET)
    public ResponseEntity<Object> approveUpdateUser(@PathVariable int id)
    {
        return userServiceInterface.saveModifyUser(id);
    }

    // approve update data
    @RequestMapping(value = "/approve_update/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> approveUpdate(@PathVariable int id, String userName)
    {
        return userServiceInterface.updateUser(id,userName);
    }


    // getting all temp user using temp no dto url
    @RequestMapping(value = "/get_temp", method = RequestMethod.GET)
    public List<TempUser> getAllTempUserNo()
    {
        List<TempUser> tempUsers = userServiceInterface.getAllTempUser();
        return tempUsers;
    }

}
