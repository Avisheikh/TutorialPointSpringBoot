package com.practise.register.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse
{
    List<UserDTO> getAllUser;
}
