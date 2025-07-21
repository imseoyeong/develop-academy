package com.example.demo_db.controller;

import com.example.demo_db.data.dto.AdminAuthenDTO;
import com.example.demo_db.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class AdminController {
    private final AdminService adminService;

    @PostMapping(value="/admin-join")
    public ResponseEntity<String> join(@RequestBody AdminAuthenDTO adminAuthenDTO) {
        AdminAuthenDTO saveAdminAuthenDTO = this.adminService.saveAdmin(adminAuthenDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
    }
}

