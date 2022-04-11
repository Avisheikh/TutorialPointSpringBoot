package com.practise.register.dto;

import com.practise.register.model.User;

import java.util.Date;

public class ModifyUserRequest
{

    private int id;
    private String userName;
    private String email;
    private int phoneNumber;
    private int pan;
    private String password;
    private Date createdDate;
    private String createdBy;
    private User user;

}
