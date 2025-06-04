package com.example.demo_db.controller;

import com.example.demo_db.jwt.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class ReissueController {
    private final JwtUtil jwtUtil;

    @PostMapping(value = "/reissue")
    public ResponseEntity<String> reissue(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {
                refreshToken = cookie.getValue();
                break;
            }
        }
        if (refreshToken == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("토큰 null");
        }

        try {
            jwtUtil.isExpired(refreshToken);
        } catch (ExpiredJwtException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("만료된 토큰");
        }

        String category = this.jwtUtil.getCategory(refreshToken);
        if (!category.equals("refresh")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 토큰");
        }

        String username = jwtUtil.getUsername(refreshToken);
        String role = jwtUtil.getRole(refreshToken);
        String newAccessToken = this.jwtUtil.createToken("access", username, role, 5000L);
        response.addHeader("Authorization", "Bearer " + newAccessToken);
        return ResponseEntity.status(HttpStatus.OK).body("토큰 발급 성공");
    }

    @DeleteMapping("/refresh-cookie")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("refresh", null);
        cookie.setPath("/reissue");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0); // 즉시 만료
        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }
}