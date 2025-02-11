package com.example.demo.controller.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/jwt")
public class AdminControllerJWT {

    @GetMapping("/admin")
    public String adminP() {

        return "admin Controller";
    }
}
