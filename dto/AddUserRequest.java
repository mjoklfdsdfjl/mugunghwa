package com.example.mugunghwa.dto;

import com.example.mugunghwa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class AddUserRequest {
    private Long id;


    private String memId;


    private String password;


    private String memName;

    private String nickname;


    private String birthDay;


    private String gender;


    private String email;


    private String memPhone;


    private String country;


    private String city;


    private String province;


    private String memAdd;


    private String clearanceNum;


    public User toEntity() {
        return new User(id, memId, password, memName, nickname, birthDay, gender,
                email, memPhone, country, city, province, memAdd, clearanceNum);
    }
}