package com.security.auth.authentication_object;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordAuthentication extends UsernamePasswordAuthenticationToken {

    public UsernamePasswordAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> grantedAuthorities)
    {
        super(principal,credentials,grantedAuthorities);
    }

    public UsernamePasswordAuthentication(Object principal, Object credentials)
    {
        super(principal,credentials);
    }
}
