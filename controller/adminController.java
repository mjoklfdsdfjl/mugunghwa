package com.example.mugunghwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminController {

    @GetMapping("/admin/home")
    public String login() {
        return "admin/adminMain";
    }
}
