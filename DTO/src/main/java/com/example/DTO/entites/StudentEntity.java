package com.example.DTO.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student_model")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "user_name")
    private String userName;

    private int age;

}