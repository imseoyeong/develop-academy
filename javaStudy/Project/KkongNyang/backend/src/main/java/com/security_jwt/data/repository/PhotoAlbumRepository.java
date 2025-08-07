package com.security_jwt.data.repository;

import com.security_jwt.data.entity.PhotoalbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoAlbumRepository extends JpaRepository<PhotoalbumEntity, Integer> {
    List<PhotoalbumEntity> findByCode_Code(String coupleCode);
}
