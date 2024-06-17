package com.example.mugunghwa.repository;

import com.example.mugunghwa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String memId);  //이메일로 사용자 정보 가져옴

    boolean existsByEmail(String email);
}

