package com.example.demo.controller.securtiy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class LoginController {

    @GetMapping("/login")
    public String loginP() {
        return "/security/login";
    }
}
