package com.practise.register.dto;

import lombok.Data;

@Data
public class UserDTO
{
    private int id;
    private String userName;
    private String email;
    private int phoneNumber;
    private int pan;
    private String password;
    private String createdBy;
}
