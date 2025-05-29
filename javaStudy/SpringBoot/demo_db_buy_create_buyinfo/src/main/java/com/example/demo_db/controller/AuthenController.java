package com.example.demo_db.controller;

import com.example.demo_db.data.dto.AuthenDTO;
import com.example.demo_db.data.entity.AuthenEntity;
import com.example.demo_db.data.repository.AuthenRepository;
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

    @PostMapping(value = "/admin-join")
    public ResponseEntity<String> adminJoin(@RequestBody AuthenDTO authenDTO) {
        if (this.authenRepository.existsById(authenDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 아이디입니다.");
        }

        AuthenEntity authenEntity = AuthenEntity.builder()
                .username(authenDTO.getUsername())
                .password(this.passwordEncoder.encode(authenDTO.getPassword()))
                .role("ROLE_ADMIN")
                .build();
        this.authenRepository.save(authenEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
    }

}
