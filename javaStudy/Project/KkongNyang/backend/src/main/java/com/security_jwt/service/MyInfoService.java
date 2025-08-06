package com.security_jwt.service;

import com.security_jwt.data.dao.MyInfoDAO;
import com.security_jwt.data.dto.MyInfoDTO;
import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MyInfoService {
    private final MyInfoDAO myInfoDAO;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public boolean checkPassword(String username, String password) {
        return myInfoDAO.checkPassword(username, password);
    }

    public void updateMyInfo(MyInfoDTO myInfoDTO) throws IOException {
        String profileImageUrl = null;
        MultipartFile profileImage = myInfoDTO.getProfileImage();

        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String originalFileName = profileImage.getOriginalFilename();
                String extension = "";
                if (originalFileName != null && originalFileName.contains(".")) {
                    extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                }
                String newFileName = UUID.randomUUID().toString() + extension;
                Path savePath = Paths.get(uploadDir + newFileName);
                Files.createDirectories(savePath.getParent());
                Files.write(savePath, profileImage.getBytes());
                profileImageUrl = savePath.toString();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

        myInfoDAO.updateProfile(myInfoDTO.getUsername(), myInfoDTO.getNickname(), profileImageUrl);
        myInfoDAO.updateAuth(myInfoDTO.getUsername(), myInfoDTO.getGender(), myInfoDTO.getBirthday(), myInfoDTO.getNewPassword());
    }

    public MyInfoDTO getMyInfo(String username) {
        AuthEntity authEntity = myInfoDAO.getAuthEntity(username);
        ProfileEntity profileEntity = myInfoDAO.getProfileEntity(username);

        return MyInfoDTO.builder()
                .username(authEntity.getUsername())
                .realname(authEntity.getRealname())
                .nickname(profileEntity.getNickname())
                .gender(authEntity.getGender())
                .birthday(authEntity.getBirthday().toString())
                .profileImage(null) // DTO에는 이미지 파일 자체를 담지 않음
                .coupleCode(profileEntity.getCouplecode())
                .build();
    }
}
