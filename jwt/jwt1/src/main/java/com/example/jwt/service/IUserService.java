package com.example.jwt.service;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;

import java.util.List;

public interface IUserService
{
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
