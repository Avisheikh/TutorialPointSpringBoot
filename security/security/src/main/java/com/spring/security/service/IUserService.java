package com.spring.security.service;

import com.spring.security.entity.Role;
import com.spring.security.entity.User;

import java.util.List;

public interface IUserService
{
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
