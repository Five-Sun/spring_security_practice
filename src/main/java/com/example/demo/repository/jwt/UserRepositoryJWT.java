package com.example.demo.repository.jwt;

import com.example.demo.entity.jwt.UserEntityJWT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJWT extends JpaRepository<UserEntityJWT, Integer> {

    Boolean existsByUsername(String username);

    //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserEntityJWT findByUsername(String username);
}
