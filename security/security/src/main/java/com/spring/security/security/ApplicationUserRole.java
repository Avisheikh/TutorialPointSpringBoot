package com.spring.security.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static  com.spring.security.security.ApplicationUserPermission.*;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole
{
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;

//    private ApplicationUserPermission permission;
//
//    ApplicationUserRole( ApplicationUserPermission applicationUserPermission)
//    {
//        this.permission = applicationUserPermission;
//    }

    ApplicationUserRole(Set<ApplicationUserPermission> permission)
    {
        this.permissions = permission;
        System.out.println(this.permissions);
    }

    public Set<ApplicationUserPermission> getPermissions()
    {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities()
    {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
