package com.example.authen_session_study.controller;

import com.example.authen_session_study.data.dto.AuthenDTO;
import com.example.authen_session_study.data.entity.AuthenEntity;
import com.example.authen_session_study.data.repository.AuthenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenController {
    private final AuthenRepository authenRepository;
    private final PasswordEncoder passwordEncoder;

    // 첫 화면에 헬로 월드 노출
    @GetMapping(value = "/")
    public String index() {
        return "Hello World";
    }

    // admin으로 들어갔을 때 헬로 어드민 노출
    @GetMapping(value = "/admin")
    public String admin() {
        return "Hello Admin";
    }

    // 회원가입 시 나타나는 문구
    @PostMapping(value = "/join")
    public ResponseEntity<String> join(@ResponseBody AuthenDTO authenDTO) { // 정보가 알려지면 안되니까 ResponseBody 사용?
        if (this.authenRepository.existsById(authenDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디입니다.");
        }

        AuthenEntity authenEntity = AuthenEntity.builder()
                .username(authenDTO.getUsername())
                .password(this.passwordEncoder.encode(authenDTO.getPassword()))
                .role("ROLE_USER")
                .build();
        this.authenRepository.save(authenEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
    }



}
