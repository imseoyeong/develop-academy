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
public class CoupleProfileDTO {
    private String coupleCode;
    private MultipartFile coupleProfileImageFile;
    private String coupleStory;
    private LocalDate firstday;
    private String profileImageUrl; // To store the URL after upload
    private String part1Nickname;
    private String part2Nickname;
}
