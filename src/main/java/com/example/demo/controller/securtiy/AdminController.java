package com.example.demo.controller.securtiy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class AdminController {

    @GetMapping("/admin")
    public String adminP() {
        return "/security/admin";
    }
}
