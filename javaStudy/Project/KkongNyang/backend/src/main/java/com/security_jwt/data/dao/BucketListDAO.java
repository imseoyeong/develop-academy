package com.security_jwt.data.dao;

import com.security_jwt.data.dto.BucketListDTO;
import com.security_jwt.data.entity.BucketListEntity;
import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.data.repository.BucketListRepository;
import com.security_jwt.data.repository.CoupleMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BucketListDAO {

    private final BucketListRepository bucketListRepository;
    private final CoupleMatchRepository coupleMatchRepository;

    @Autowired
    public BucketListDAO(BucketListRepository bucketListRepository, CoupleMatchRepository coupleMatchRepository) {
        this.bucketListRepository = bucketListRepository;
        this.coupleMatchRepository = coupleMatchRepository;
    }

    public void addBucketList(String coupleCode, String todo) {
        CoupleMatchEntity coupleMatchEntity = coupleMatchRepository.findByCode(coupleCode).orElseThrow(() -> new RuntimeException("Couple not found"));
        BucketListEntity bucketListEntity = BucketListEntity.builder()
                .code(coupleMatchEntity)
                .todo(todo)
                .createdDate(LocalDateTime.now())
                .build();
        bucketListRepository.save(bucketListEntity);
    }

    public void completeBucketList(Integer bucketListId) {
        BucketListEntity bucketListEntity = bucketListRepository.findById(bucketListId).orElseThrow(() -> new RuntimeException("BucketList not found"));
        bucketListEntity.setCompletedDate(LocalDateTime.now());
        bucketListRepository.save(bucketListEntity);
    }

    public void deleteCompletedBucketLists(String coupleCode) {
        bucketListRepository.deleteCompletedByCoupleCode(coupleCode);
    }

    public List<BucketListDTO> getBucketListsByCoupleCode(String coupleCode) {
        CoupleMatchEntity coupleMatchEntity = coupleMatchRepository.findByCode(coupleCode).orElseThrow(() -> new RuntimeException("Couple not found"));
        return coupleMatchEntity.getBucketList().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteBucketList(Integer bucketListId) {
        bucketListRepository.deleteById(bucketListId);
    }

    private BucketListDTO convertToDTO(BucketListEntity bucketListEntity) {
        return BucketListDTO.builder()
                .id(bucketListEntity.getId())
                .todo(bucketListEntity.getTodo())
                .createdDate(bucketListEntity.getCreatedDate())
                .completedDate(bucketListEntity.getCompletedDate())
                .build();
    }
}