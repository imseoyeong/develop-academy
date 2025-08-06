package com.security_jwt.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyInfoDTO {
    private String username;
    private String password;
    private String newPassword;
    private String realname;
    private String nickname;
    private String gender;
    private String birthday;
    private MultipartFile profileImage;
    private String coupleCode;
}
