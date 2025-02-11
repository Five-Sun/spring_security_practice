package com.example.demo.service.jwt;

import com.example.demo.dto.jwt.CustomUserDetailJWT;
import com.example.demo.dto.security.CustomUserDetail;
import com.example.demo.entity.jwt.UserEntityJWT;
import com.example.demo.repository.jwt.UserRepositoryJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceJWT implements UserDetailsService {

    private final UserRepositoryJWT userRepositoryJWT;

    public CustomUserDetailsServiceJWT(UserRepositoryJWT userRepositoryJWT) {
        this.userRepositoryJWT = userRepositoryJWT;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntityJWT userData = userRepositoryJWT.findByUsername(username);

        if (userData != null) {
            return new CustomUserDetailJWT(userData);
        }

        return null;
    }
}
