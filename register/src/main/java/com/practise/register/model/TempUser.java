package com.practise.register.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "temp_user")
public class TempUser
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "phone_number")
    private int phoneNumber;

    @NotNull
    @Column(name = "pan")
    private int pan;

    @NotNull
    @Column(name = "password")
    private String password;


    @Column(name = "is_approved")
    private String isApproved;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    public TempUser(){}

    public TempUser(String userName, String email, int phoneNumber, int pan, String password, String isApproved, Date createdDate) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pan = pan;
        this.password = password;
        this.isApproved = isApproved;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(int pan) {
        this.pan = pan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "TempUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", pan=" + pan +
                ", password='" + password + '\'' +
                ", isApproved='" + isApproved + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
