package com.security_jwt.controller;


import com.security_jwt.data.dto.AuthDTO;
import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/join")
    public ResponseEntity<String> join(@RequestBody AuthDTO authDTO) {
        AuthDTO auth = authService.join(authDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
    }

    @GetMapping(value="/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.status(HttpStatus.OK).body("관리자입니다.");
    }
}
