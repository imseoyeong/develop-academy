package com.security_jwt.controller;

import com.security_jwt.data.dto.MyInfoDTO;
import com.security_jwt.service.MyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/my-info")
public class MyInfoController {

    private final MyInfoService myInfoService;

    @PostMapping("/check-password")
    public ResponseEntity<String> checkPassword(@AuthenticationPrincipal UserDetails userDetails, @RequestBody MyInfoDTO myInfoDTO) {
        boolean matches = myInfoService.checkPassword(userDetails.getUsername(), myInfoDTO.getPassword());
        if (matches) {
            return ResponseEntity.ok("비밀번호가 일치합니다.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMyInfo(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute MyInfoDTO myInfoDTO) {
        myInfoDTO.setUsername(userDetails.getUsername());
        try {
            myInfoService.updateMyInfo(myInfoDTO);
            return ResponseEntity.ok("내 정보가 성공적으로 수정되었습니다.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미지 업로드 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("")
    public ResponseEntity<MyInfoDTO> getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
        MyInfoDTO myInfoDTO = myInfoService.getMyInfo(userDetails.getUsername());
        return ResponseEntity.ok(myInfoDTO);
    }
}
