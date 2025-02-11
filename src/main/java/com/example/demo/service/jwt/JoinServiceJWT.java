package com.example.demo.service.jwt;

import com.example.demo.dto.security.JoinDTO;
import com.example.demo.entity.jwt.UserEntityJWT;
import com.example.demo.repository.jwt.UserRepositoryJWT;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceJWT {

    private final UserRepositoryJWT userRepositoryJWT;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinServiceJWT(UserRepositoryJWT userRepositoryJWT, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepositoryJWT = userRepositoryJWT;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepositoryJWT.existsByUsername(username);

        if (isExist) {

            return;
        }

        UserEntityJWT data = new UserEntityJWT();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepositoryJWT.save(data);
    }
}
