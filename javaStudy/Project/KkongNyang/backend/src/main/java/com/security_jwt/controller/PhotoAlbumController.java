package com.security_jwt.controller;

import com.security_jwt.data.dto.PhotoAlbumDTO;
import com.security_jwt.service.PhotoAlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/photoalbum")
public class PhotoAlbumController {

    private final PhotoAlbumService photoAlbumService;

    // 1. photoalbum에 사진정보 등록하는 api
    @PostMapping("/create")
    public ResponseEntity<PhotoAlbumDTO> createPhotoAlbum(
            @AuthenticationPrincipal UserDetails userDetails,
            @ModelAttribute PhotoAlbumDTO photoAlbumDTO) {
        String username = userDetails.getUsername();
        PhotoAlbumDTO createdPhotoAlbum = photoAlbumService.createPhotoAlbum(photoAlbumDTO, username);
        if (createdPhotoAlbum != null) {
            return ResponseEntity.ok(createdPhotoAlbum);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // 2. photoalbum에 사진정보 삭제하는 api
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoAlbum(@PathVariable Integer id) {
        boolean deleted = photoAlbumService.deletePhotoAlbum(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 3. photoalbum에 사진정보 수정하는 api
    @PutMapping("/{id}")
    public ResponseEntity<PhotoAlbumDTO> updatePhotoAlbum(
            @PathVariable Integer id,
            @ModelAttribute PhotoAlbumDTO photoAlbumDTO) {
        PhotoAlbumDTO updatedPhotoAlbum = photoAlbumService.updatePhotoAlbum(id, photoAlbumDTO);
        if (updatedPhotoAlbum != null) {
            return ResponseEntity.ok(updatedPhotoAlbum);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 4. 특정 photoalbum 사진정보를 전달하는 api
    @GetMapping("/{id}")
    public ResponseEntity<PhotoAlbumDTO> getPhotoAlbumById(@PathVariable Integer id) {
        PhotoAlbumDTO photoAlbum = photoAlbumService.getPhotoAlbumById(id);
        if (photoAlbum != null) {
            return ResponseEntity.ok(photoAlbum);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 5. 특정 커플의 모든 photoalbum 사진정보를 전달하는 api
    @GetMapping("/couple/{coupleCode}")
    public ResponseEntity<List<PhotoAlbumDTO>> getPhotoAlbumsByCoupleCode(@PathVariable String coupleCode) {
        List<PhotoAlbumDTO> photoAlbums = photoAlbumService.getPhotoAlbumsByCoupleCode(coupleCode);
        return ResponseEntity.ok(photoAlbums);
    }
} 