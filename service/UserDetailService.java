package com.example.mugunghwa.service;

import com.example.mugunghwa.entity.User;
import com.example.mugunghwa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//사용자 인증을 위해 Spring Security를 ​​사용하여 Spring Boot 애플리케이션을 작업
@RequiredArgsConstructor //필드를 초기화하는 생성자를 생성
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String memId) {
        return userRepository.findByEmail(memId)
                .orElseThrow(() -> new IllegalArgumentException((memId)));
    }
}
