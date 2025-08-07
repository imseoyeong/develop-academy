package com.security_jwt.data.dao.impl;

import com.security_jwt.data.dao.PhotoAlbumDAO;
import com.security_jwt.data.entity.PhotoalbumEntity;
import com.security_jwt.data.repository.PhotoAlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PhotoAlbumDAOImpl implements PhotoAlbumDAO {

    private final PhotoAlbumRepository photoAlbumRepository;

    @Override
    public PhotoalbumEntity savePhotoAlbum(PhotoalbumEntity photoalbumEntity) {
        return photoAlbumRepository.save(photoalbumEntity);
    }

    @Override
    public Optional<PhotoalbumEntity> findById(Integer id) {
        return photoAlbumRepository.findById(id);
    }

    @Override
    public List<PhotoalbumEntity> findByCoupleCode(String coupleCode) {
        return photoAlbumRepository.findByCode_Code(coupleCode);
    }

    @Override
    public void deleteById(Integer id) {
        photoAlbumRepository.deleteById(id);
    }

    @Override
    public PhotoalbumEntity updatePhotoAlbum(PhotoalbumEntity photoalbumEntity) {
        return photoAlbumRepository.save(photoalbumEntity);
    }
} 