package com.example.mugunghwa.service;

import com.example.mugunghwa.dto.AddUserRequest;
import com.example.mugunghwa.entity.User;
import com.example.mugunghwa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        if (isEmailExists(dto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        return userRepository.save(User.builder()
                .memId(dto.getMemId())
                //패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .memName(dto.getMemName())
                .nickname(dto.getNickname())
                .birthDay(dto.getBirthDay())
                .gender(dto.getGender())
                .email(dto.getEmail())
                .memPhone(dto.getMemPhone())
                .country(dto.getCountry())
                .city(dto.getCity())
                .province(dto.getProvince())
                .memAdd(dto.getMemAdd())
                .clearanceNum(dto.getClearanceNum())
                .build()).getId();


    }


    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }



    public void saveUser(User user) {
        userRepository.save(user);
    }



    public void registerUser(User user) {
        userRepository.save(user);
    }


}
