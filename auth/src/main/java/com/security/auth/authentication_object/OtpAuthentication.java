package com.security.auth.authentication_object;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OtpAuthentication extends UsernamePasswordAuthenticationToken {

    public OtpAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> grantedAuthorities)
    {
        super(principal, credentials, grantedAuthorities);
    }

    public OtpAuthentication(Object principal, Object credentials)
    {
        super(principal, credentials);
    }

}
