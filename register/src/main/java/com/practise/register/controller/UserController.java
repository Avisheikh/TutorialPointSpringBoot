package com.practise.register.controller;

import com.practise.register.dto.TempUserDTO;
import com.practise.register.dto.TempUserRequest;
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
import java.util.Map;

@RestController
public class UserController
{

    @Autowired
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/approve_user", method = RequestMethod.GET)
    public void approveUser()
    {
        userServiceInterface.saveUser(3);
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


        ResponseEntity<Object> user = null;

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

        try
        {
            user = userServiceInterface.createTempUserDTO(tempUser);
        }

        catch (Exception e)
        {
            System.out.println(e);
            return  new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        }

        return user;
    }



}
