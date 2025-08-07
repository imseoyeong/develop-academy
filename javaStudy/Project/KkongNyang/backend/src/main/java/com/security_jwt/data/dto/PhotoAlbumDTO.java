package com.security_jwt.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoAlbumDTO {
    private Integer id;
    private String coupleCode;
    private String img;
    private String title;
    private String story;
    private MultipartFile imageFile; // 이미지 파일 업로드용
}
