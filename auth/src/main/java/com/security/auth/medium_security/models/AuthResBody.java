package com.security.auth.medium_security.models;

public class AuthResBody {

    private final Boolean authenticated;

    public AuthResBody(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }
}
