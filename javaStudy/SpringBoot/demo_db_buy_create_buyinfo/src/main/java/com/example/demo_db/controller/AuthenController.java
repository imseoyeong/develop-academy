package com.example.demo_db.controller;

import com.example.demo_db.data.dto.AuthenDTO;
import com.example.demo_db.data.entity.AuthenEntity;
import com.example.demo_db.data.repository.AuthenRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthenController {
    private final AuthenRepository authenRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/csrf-token")
    public ResponseEntity<Map<String, String>> csrfToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        Map<String, String> map = new HashMap<>();
        map.put("csrf-token", csrfToken.getToken());
        return ResponseEntity.ok(map);
    }

    @PostMapping(value = "/admin-join")
    public ResponseEntity<String> adminJoin(@RequestBody AuthenDTO authenDTO) {
        if (!"1234".equals(authenDTO.getCodenum())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("잘못된 인증번호입니다.");
        }

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

    // 비밀번호 암호화 임시로 해놓기 (포스트맨으로 요청 보내기!)
//    @GetMapping(value = "/password")
//    public String password() {
//        List<AuthenEntity> list = this.authenRepository.findAll();
//        for (AuthenEntity authenEntity : list) {
//            AuthenEntity entity = AuthenEntity.builder()
//                    .username(authenEntity.getUsername())
//                    .password(this.passwordEncoder.encode(authenEntity.getPassword()))
//                    .role(authenEntity.getRole())
//                    .build();
//            this.authenRepository.save(entity);
//        }
//        return "success";
//    }

}
