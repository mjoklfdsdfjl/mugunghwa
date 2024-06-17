package com.example.mugunghwa.controller;

import com.example.mugunghwa.dto.AddUserRequest;

import com.example.mugunghwa.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import com.example.mugunghwa.entity.User;
import com.example.mugunghwa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserViewController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {

        return "login/login";
    }



    @GetMapping("/join")
    public String userjoin() {
           return "join/join";
    }

    @PostMapping("/user")
    public String signup(@ModelAttribute AddUserRequest dto, Model model) {
        try {
            userService.save(dto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
//            userService.save(dto);  //회원 가입 메소드 호출
            return "join/join";
        }
        return "login/login";  //회원 가입 완료된 이후에 로그인 페이지로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }






}
