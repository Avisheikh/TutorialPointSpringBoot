package com.example.BeanNDependencyInjection.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "user_location_dto")
public class UserLocationDTO
{
    private int userID;
    private String email;
    private String place;
    private int longtitude;
}
