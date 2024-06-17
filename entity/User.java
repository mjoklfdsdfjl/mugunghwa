package com.example.mugunghwa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false, unique = true)
    private String memId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cst_name", nullable = false)
    private String memName;

    @Column(name = "cst_nickname", nullable = false,  unique = true)
    private String nickname;

    @Column(name = "cst_ymd", nullable = false)
    private String birthDay;

    @Column(name = "cst_gender", nullable = false)
    private String gender;

    @Column(name = "cst_email", nullable = false,  unique = true)
    private String email;

    @Column(name = "cst_phone", nullable = false)
    private String memPhone;

    @Column(name = "odr_country", nullable = false)
    private String country;

    @Column(name = "odr_city", nullable = false)
    private String city;

    @Column(name = "dor_province", nullable = false)
    private String province;

    @Column(name = "odr_adress", nullable = false)
    private String memAdd;

    @Column(name = "odr_customscode")
    private String clearanceNum;


//    public User() {}

    @Builder
    public User(String memId, String password, String memName, String nickname,  String birthDay, String gender, String email,
                String memPhone, String country, String city, String province, String memAdd, String clearanceNum) {
        this.memId = memId;
        this.password = password;
        this.memName = memName;
        this.nickname = nickname;
        this.birthDay = birthDay;
        this.gender = gender;
        this.email = email;
        this.memPhone = memPhone;
        this.country = country;
        this.city = city;
        this.province = province;
        this.memAdd = memAdd;
        this.clearanceNum = clearanceNum;
        }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
//이메일 반환
    @Override
    public String getUsername() {
        return email;
    }

//    비밀번호 반환
    @Override
    public String getPassword() {
        return password;
    }


    //계정 사용 여부 true는 사용가능
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨 있지 않음(true)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //패스워드 사용여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화 됨
    @Override
    public boolean isEnabled() {
        return true;
    }
}