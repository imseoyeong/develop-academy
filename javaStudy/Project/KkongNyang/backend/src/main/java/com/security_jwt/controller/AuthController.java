package com.security_jwt.controller;

import com.security_jwt.data.dto.JoinDTO;
import com.security_jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/join")
    public ResponseEntity<String> join(@ModelAttribute JoinDTO joinDTO) throws IOException {
        boolean result = authService.join(joinDTO);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("가입실패");
        }
    }
}