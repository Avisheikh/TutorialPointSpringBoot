package com.example.oauth.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class UserEntity
{
    private String username;
    private String password;
    private Collection<GrantedAuthority> grantedAuthorityCollection = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GrantedAuthority> getGrantedAuthorityCollection() {
        return grantedAuthorityCollection;
    }

    public void setGrantedAuthorityCollection(Collection<GrantedAuthority> grantedAuthorityCollection) {
        this.grantedAuthorityCollection = grantedAuthorityCollection;
    }
}
