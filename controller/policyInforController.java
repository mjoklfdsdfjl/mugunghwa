package com.example.mugunghwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class policyInforController {

    @GetMapping("/policy/policies")
    public String polici() {
        return "policyInfor/policies";
    }

    @GetMapping("/policy/private")
    public String priva() {
        return "policyInfor/private";
    }
}
