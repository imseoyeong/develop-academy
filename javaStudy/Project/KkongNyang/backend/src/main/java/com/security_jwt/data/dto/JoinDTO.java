package com.security_jwt.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinDTO {
    private String username;
    private String password;
    private String gender;
    private String realname;
    private String nickname;
    private MultipartFile profileimg;
    private LocalDate birthday;
}