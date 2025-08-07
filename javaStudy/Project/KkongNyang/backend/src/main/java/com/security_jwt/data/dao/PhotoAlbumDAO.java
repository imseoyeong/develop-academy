package com.security_jwt.data.dao;

import com.security_jwt.data.dto.PhotoAlbumDTO;
import com.security_jwt.data.entity.PhotoalbumEntity;

import java.util.List;
import java.util.Optional;

public interface PhotoAlbumDAO {
    PhotoalbumEntity savePhotoAlbum(PhotoalbumEntity photoalbumEntity);
    Optional<PhotoalbumEntity> findById(Integer id);
    List<PhotoalbumEntity> findByCoupleCode(String coupleCode);
    void deleteById(Integer id);
    PhotoalbumEntity updatePhotoAlbum(PhotoalbumEntity photoalbumEntity);
} 