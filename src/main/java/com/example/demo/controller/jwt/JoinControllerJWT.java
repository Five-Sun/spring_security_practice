package com.example.demo.controller.jwt;

import com.example.demo.dto.security.JoinDTO;
import com.example.demo.service.jwt.JoinServiceJWT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/jwt")
public class JoinControllerJWT {

    private final JoinServiceJWT joinServiceJWT;

    public JoinControllerJWT(JoinServiceJWT joinServiceJWT) {

        this.joinServiceJWT = joinServiceJWT;
    }

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {

        System.out.println(joinDTO.getUsername());
        joinServiceJWT.joinProcess(joinDTO);

        return "ok";
    }
}