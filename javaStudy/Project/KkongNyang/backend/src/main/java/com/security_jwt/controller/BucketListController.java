package com.security_jwt.controller;

import com.security_jwt.data.dto.BucketListDTO;
import com.security_jwt.service.BucketListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bucketlist")
public class BucketListController {

    private final BucketListService bucketListService;

    @Autowired
    public BucketListController(BucketListService bucketListService) {
        this.bucketListService = bucketListService;
    }

//    bucketlist를 추가하는 api
    @PostMapping("/{coupleCode}")
    public ResponseEntity<Void> addBucketList(@PathVariable String coupleCode, @RequestBody String todo) {
        bucketListService.addBucketList(coupleCode, todo);
        return ResponseEntity.ok().build();
    }
//    bucketlist를 완료하는 api
    @PutMapping("/{bucketListId}")
    public ResponseEntity<Void> completeBucketList(@PathVariable Integer bucketListId) {
        bucketListService.completeBucketList(bucketListId);
        return ResponseEntity.ok().build();
    }

//    완료된 bucketlist를 삭제하는 api
    @DeleteMapping("/completed/{coupleCode}")
    public ResponseEntity<Void> deleteCompletedBucketLists(@PathVariable String coupleCode) {
        bucketListService.deleteCompletedBucketLists(coupleCode);
        return ResponseEntity.ok().build();
    }

//    한 커플의 bucketlist를 모두 전달하는 api
    @GetMapping("/{coupleCode}")
    public ResponseEntity<List<BucketListDTO>> getBucketListsByCoupleCode(@PathVariable String coupleCode) {
        return ResponseEntity.ok(bucketListService.getBucketListsByCoupleCode(coupleCode));
    }

//    특정 bucketlist를 삭제하는 api
    @DeleteMapping("/{bucketListId}")
    public ResponseEntity<Void> deleteBucketList(@PathVariable Integer bucketListId) {
        bucketListService.deleteBucketList(bucketListId);
        return ResponseEntity.ok().build();
    }
}
