package com.practise.register.dto;

import com.practise.register.model.User;
import lombok.Data;

import java.util.Date;

@Data
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
