package com.security_jwt.service;

import com.security_jwt.data.dao.CoupleProfileDAO;
import com.security_jwt.data.dto.CoupleProfileDTO;
import com.security_jwt.data.entity.CoupleMatchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoupleProfileService {

    private final CoupleProfileDAO coupleProfileDAO;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Transactional
    public CoupleProfileDTO updateCoupleProfile(CoupleProfileDTO coupleProfileDTO, String username) {
        Optional<CoupleMatchEntity> coupleMatchOpt = coupleProfileDAO.findCoupleMatchByCode(coupleProfileDTO.getCoupleCode());

        if (coupleMatchOpt.isPresent()) {
            CoupleMatchEntity coupleMatch = coupleMatchOpt.get();
            String profileImgUrl = coupleMatch.getProfileimage(); // Keep existing image if no new one is uploaded

            MultipartFile coupleProfileImageFile = coupleProfileDTO.getCoupleProfileImageFile();
            if (coupleProfileImageFile != null && !coupleProfileImageFile.isEmpty()) {
                try {
                    String originalFileName = coupleProfileImageFile.getOriginalFilename();
                    String extension = "";
                    if (originalFileName != null && originalFileName.contains(".")) {
                        extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    }
                    String newFileName = UUID.randomUUID().toString() + extension;
                    Path savePath = Paths.get(uploadDir + newFileName);
                    Files.createDirectories(savePath.getParent());
                    Files.write(savePath, coupleProfileImageFile.getBytes());
                    profileImgUrl = savePath.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle exception, maybe return null or throw a custom exception
                    return null;
                }
            }

            coupleMatch.setProfileimage(profileImgUrl);
            coupleMatch.setCouplestory(coupleProfileDTO.getCoupleStory());
            coupleMatch.setFirstday(coupleProfileDTO.getFirstday());

            // Update both nicknames
            coupleMatch.setPart1nickname(coupleProfileDTO.getPart1Nickname());
            coupleMatch.setPart2nickname(coupleProfileDTO.getPart2Nickname());

            CoupleMatchEntity updatedCoupleMatch = coupleProfileDAO.updateCoupleProfile(coupleMatch);
            return CoupleProfileDTO.builder()
                    .coupleCode(updatedCoupleMatch.getCode())
                    .profileImageUrl(updatedCoupleMatch.getProfileimage())
                    .coupleStory(updatedCoupleMatch.getCouplestory())
                    .firstday(updatedCoupleMatch.getFirstday())
                    .part1Nickname(updatedCoupleMatch.getPart1nickname())
                    .part2Nickname(updatedCoupleMatch.getPart2nickname())
                    .build();
        }
        return null;
    }

    @Transactional
    public boolean dissolveCouple(String coupleCode) {
        Optional<CoupleMatchEntity> coupleMatchOpt = coupleProfileDAO.findCoupleMatchByCode(coupleCode);
        if (coupleMatchOpt.isPresent()) {
            coupleProfileDAO.deleteCouple(coupleCode);
            return true;
        }
        return false;
    }

    public CoupleProfileDTO getCoupleProfile(String coupleCode) {
        Optional<CoupleMatchEntity> coupleMatchOpt = coupleProfileDAO.findCoupleMatchByCode(coupleCode);
        if (coupleMatchOpt.isPresent()) {
            CoupleMatchEntity coupleMatch = coupleMatchOpt.get();
            return CoupleProfileDTO.builder()
                    .coupleCode(coupleMatch.getCode())
                    .profileImageUrl(coupleMatch.getProfileimage())
                    .coupleStory(coupleMatch.getCouplestory())
                    .part1Nickname(coupleMatch.getPart1nickname())
                    .part2Nickname(coupleMatch.getPart2nickname())
                    .firstday(coupleMatch.getFirstday())
                    .build();
        }
        return null;
    }
}
