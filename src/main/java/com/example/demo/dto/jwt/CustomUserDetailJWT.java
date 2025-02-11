package com.example.demo.dto.jwt;

import com.example.demo.entity.jwt.UserEntityJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetailJWT implements UserDetails {

    private final UserEntityJWT userEntityJWT;
    public CustomUserDetailJWT(UserEntityJWT userEntityJWT) {
        this.userEntityJWT = userEntityJWT;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userEntityJWT.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userEntityJWT.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntityJWT.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
