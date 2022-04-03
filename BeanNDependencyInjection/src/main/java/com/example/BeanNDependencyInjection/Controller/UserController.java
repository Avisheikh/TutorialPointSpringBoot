package com.example.BeanNDependencyInjection.Controller;

import com.example.BeanNDependencyInjection.DTO.UserLocationDTO;
import com.example.BeanNDependencyInjection.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/user_location")
//    public List<UserLocationDTO> getAllUserLocation()
//    {
//        return userService.getAllUsersLocation();
//    }
}
