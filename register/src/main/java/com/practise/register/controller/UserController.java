package com.practise.register.controller;

import com.practise.register.model.TempUser;
import com.practise.register.serviceInterface.UserServiceInterface;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController
{

    @Autowired
    private UserServiceInterface userServiceInterface;

    // get request from request body
    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public ResponseEntity<Object> createTempUser(@Valid @RequestBody TempUser tempUser)
    {


        ResponseEntity<Object> user = null;

        try
        {
            user = userServiceInterface.createTempUser(tempUser);
        }

        catch (Exception e)
        {
            System.out.println(e);
            return  new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        }

        return user;

    }

}
