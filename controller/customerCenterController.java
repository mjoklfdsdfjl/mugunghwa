package com.example.mugunghwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class customerCenterController {

    @GetMapping("/customerCenter/main")
    public String custC() {

        return "customerCenter/customerCenter_Main_notice";
    }

    @GetMapping("/customerCenter/notice_1")
    public String custn1() {

        return "customerCenter/customerCenter_Main_notice_1";
    }

    @GetMapping("/customerCenter/faq")
    public String custfaq() {

        return "customerCenter/customerCenter_faq";
    }

    @GetMapping("/customerCenter/board")
    public String custboard() {

        return "customerCenter/customerCenter_board";
    }
}
