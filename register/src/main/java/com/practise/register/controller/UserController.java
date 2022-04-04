package com.practise.register.controller;

import com.practise.register.dto.TempUserDTO;
import com.practise.register.dto.TempUserRequest;
import com.practise.register.exception.DataIntegrityViolationException;
import com.practise.register.model.TempUser;
import com.practise.register.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController
{

    @Autowired
    private UserServiceInterface userServiceInterface;

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


    @RequestMapping(value = "/approve_user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> approveUser(@PathVariable int id, String userName)
    {
        ResponseEntity saveUser;

        try
        {
            saveUser = userServiceInterface.saveUser(id,userName);
        }

        catch (Exception e)
        {
            throw new DataIntegrityViolationException();
        }

        return saveUser;
    }

    // getting all temp user using temp no dto
    @RequestMapping(value = "/get_temp", method = RequestMethod.GET)
    public List<TempUser> getAllTempUserNo()
    {
        List<TempUser> tempUsers = userServiceInterface.getAllTempUser();
        return tempUsers;

    }


    // getting all temp user using temp dto
//    @GetMapping(path = "sasd")
    @RequestMapping(value = "/get_temp_user", method = RequestMethod.GET)
    public List<TempUserDTO> getAllTempUser()
    {
        List<TempUserDTO> tempUserDTOS = userServiceInterface.getAllTempUserDTO();
        return tempUserDTOS;
    }


    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public ResponseEntity<Object> createTempUserDTO(@Valid @RequestBody TempUserRequest tempUser, BindingResult bindingResult,HttpServletResponse response)
    {


        ResponseEntity<Object> responsedetails = null;

        if(bindingResult.hasErrors())
        {
            String errorMessage = "";
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            List<ObjectError> errors = bindingResult.getAllErrors();

            for(ObjectError e:errors)
            {
                errorMessage += "Error: " + e.getDefaultMessage() +"\n";
                System.out.println(errorMessage);
            }

            return  new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
        }

            responsedetails = userServiceInterface.createTempUserDTO(tempUser);

        return responsedetails;
    }



}
