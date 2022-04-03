package com.example.BeanNDependencyInjection.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Column(name = "longtitude")
    private int longtitude;

    @Column(name = "latitude")
    private String latitude;
}
