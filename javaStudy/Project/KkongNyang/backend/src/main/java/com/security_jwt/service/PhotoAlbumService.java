package com.security_jwt.service;

import com.security_jwt.data.dao.PhotoAlbumDAO;
import com.security_jwt.data.dto.PhotoAlbumDTO;
import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.data.entity.PhotoalbumEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoAlbumService {

    private final PhotoAlbumDAO photoAlbumDAO;
    private final CoupleProfileService coupleProfileService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Transactional
    public PhotoAlbumDTO createPhotoAlbum(PhotoAlbumDTO photoAlbumDTO, String username) {
        // 커플 코드로 커플 매치 엔티티 찾기
        Optional<CoupleMatchEntity> coupleMatchOpt = coupleProfileService.findCoupleMatchByCode(photoAlbumDTO.getCoupleCode());
        
        if (coupleMatchOpt.isPresent()) {
            CoupleMatchEntity coupleMatch = coupleMatchOpt.get();
            String imgUrl = null;

            // 이미지 파일 처리
            MultipartFile imageFile = photoAlbumDTO.getImageFile();
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    String originalFileName = imageFile.getOriginalFilename();
                    String extension = "";
                    if (originalFileName != null && originalFileName.contains(".")) {
                        extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    }
                    String newFileName = UUID.randomUUID().toString() + extension;
                    Path savePath = Paths.get(uploadDir + newFileName);
                    Files.createDirectories(savePath.getParent());
                    Files.write(savePath, imageFile.getBytes());
                    imgUrl = savePath.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            // PhotoalbumEntity 생성
            PhotoalbumEntity photoalbumEntity = new PhotoalbumEntity();
            photoalbumEntity.setCode(coupleMatch);
            photoalbumEntity.setImg(imgUrl);
            photoalbumEntity.setTitle(photoAlbumDTO.getTitle());
            photoalbumEntity.setStory(photoAlbumDTO.getStory());

            PhotoalbumEntity savedEntity = photoAlbumDAO.savePhotoAlbum(photoalbumEntity);

            return PhotoAlbumDTO.builder()
                    .id(savedEntity.getId())
                    .coupleCode(savedEntity.getCode().getCode())
                    .img(savedEntity.getImg())
                    .title(savedEntity.getTitle())
                    .story(savedEntity.getStory())
                    .build();
        }
        return null;
    }

    @Transactional
    public boolean deletePhotoAlbum(Integer id) {
        Optional<PhotoalbumEntity> photoalbumOpt = photoAlbumDAO.findById(id);
        if (photoalbumOpt.isPresent()) {
            photoAlbumDAO.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public PhotoAlbumDTO updatePhotoAlbum(Integer id, PhotoAlbumDTO photoAlbumDTO) {
        Optional<PhotoalbumEntity> photoalbumOpt = photoAlbumDAO.findById(id);
        
        if (photoalbumOpt.isPresent()) {
            PhotoalbumEntity photoalbumEntity = photoalbumOpt.get();
            
            // 이미지 파일 처리
            MultipartFile imageFile = photoAlbumDTO.getImageFile();
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    String originalFileName = imageFile.getOriginalFilename();
                    String extension = "";
                    if (originalFileName != null && originalFileName.contains(".")) {
                        extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    }
                    String newFileName = UUID.randomUUID().toString() + extension;
                    Path savePath = Paths.get(uploadDir + newFileName);
                    Files.createDirectories(savePath.getParent());
                    Files.write(savePath, imageFile.getBytes());
                    photoalbumEntity.setImg(savePath.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            // 제목과 스토리 업데이트
            if (photoAlbumDTO.getTitle() != null) {
                photoalbumEntity.setTitle(photoAlbumDTO.getTitle());
            }
            if (photoAlbumDTO.getStory() != null) {
                photoalbumEntity.setStory(photoAlbumDTO.getStory());
            }

            PhotoalbumEntity updatedEntity = photoAlbumDAO.updatePhotoAlbum(photoalbumEntity);

            return PhotoAlbumDTO.builder()
                    .id(updatedEntity.getId())
                    .coupleCode(updatedEntity.getCode().getCode())
                    .img(updatedEntity.getImg())
                    .title(updatedEntity.getTitle())
                    .story(updatedEntity.getStory())
                    .build();
        }
        return null;
    }

    public PhotoAlbumDTO getPhotoAlbumById(Integer id) {
        Optional<PhotoalbumEntity> photoalbumOpt = photoAlbumDAO.findById(id);
        
        if (photoalbumOpt.isPresent()) {
            PhotoalbumEntity photoalbumEntity = photoalbumOpt.get();
            return PhotoAlbumDTO.builder()
                    .id(photoalbumEntity.getId())
                    .coupleCode(photoalbumEntity.getCode().getCode())
                    .img(photoalbumEntity.getImg())
                    .title(photoalbumEntity.getTitle())
                    .story(photoalbumEntity.getStory())
                    .build();
        }
        return null;
    }

    public List<PhotoAlbumDTO> getPhotoAlbumsByCoupleCode(String coupleCode) {
        List<PhotoalbumEntity> photoalbumEntities = photoAlbumDAO.findByCoupleCode(coupleCode);
        
        return photoalbumEntities.stream()
                .map(entity -> PhotoAlbumDTO.builder()
                        .id(entity.getId())
                        .coupleCode(entity.getCode().getCode())
                        .img(entity.getImg())
                        .title(entity.getTitle())
                        .story(entity.getStory())
                        .build())
                .collect(Collectors.toList());
    }
} 