package com.security_jwt.service;

import com.security_jwt.data.dao.AuthDAO;
import com.security_jwt.data.dto.JoinDTO;
import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthDAO  authDAO;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public boolean join(JoinDTO joinDTO) throws IOException {

        String profileImgUrl = null;
        MultipartFile profileimg = joinDTO.getProfileimg();

        if (profileimg != null && !profileimg.isEmpty()) {

            try {
                String originalFileName = profileimg.getOriginalFilename();
                String extension = "";
                if (originalFileName != null && originalFileName.contains(".")) {
                    extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                }
                String newFileName = UUID.randomUUID().toString() + extension;
                Path savePath = Paths.get(uploadDir + newFileName);
                Files.createDirectories(savePath.getParent());
                // 파일 저장
                Files.write(savePath, profileimg.getBytes());
                profileImgUrl = savePath.toString();

            } catch (IOException e) {
                e.printStackTrace();
                // Consider adding error handling or logging here
                return false; // fail join on image save error
            }
        }

        AuthEntity result = this.authDAO.authSave(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getRealname(), joinDTO.getGender(), joinDTO.getBirthday());
        ProfileEntity profileEntity = this.authDAO.profileSave(joinDTO.getUsername(), profileImgUrl, joinDTO.getNickname());
        if(result == null || profileEntity == null) {
            return false;
        }

        return true;
    }
}