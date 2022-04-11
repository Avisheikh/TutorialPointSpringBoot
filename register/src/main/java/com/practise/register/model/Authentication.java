package com.practise.register.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;

@Data
@Entity
public class Authentication
{

    @Id
    private int id;

    @Column(name = "is_authenticated")
    private boolean isAuthenticated;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;



}
