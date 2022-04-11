package com.practise.register.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModifyUserResponse
{

    private int id;
    private String userName;
    private String email;
    private int phoneNumber;
    private int pan;
    List<UserDTO> listModifyUser;
}
