package com.spring.security.api;

import com.spring.security.entity.User;
import com.spring.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource
{

    private final IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers()
    {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
