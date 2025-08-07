package com.security_jwt.service;

import com.security_jwt.data.dao.BucketListDAO;
import com.security_jwt.data.dto.BucketListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BucketListService {

    private final BucketListDAO bucketListDAO;

    @Autowired
    public BucketListService(BucketListDAO bucketListDAO) {
        this.bucketListDAO = bucketListDAO;
    }

    public void addBucketList(String coupleCode, String todo) {
        bucketListDAO.addBucketList(coupleCode, todo);
    }

    public void completeBucketList(Integer bucketListId) {
        bucketListDAO.completeBucketList(bucketListId);
    }

    @Transactional
    public void deleteCompletedBucketLists(String coupleCode) {
        bucketListDAO.deleteCompletedBucketLists(coupleCode);
    }

    public List<BucketListDTO> getBucketListsByCoupleCode(String coupleCode) {
        return bucketListDAO.getBucketListsByCoupleCode(coupleCode);
    }

    public void deleteBucketList(Integer bucketListId) {
        bucketListDAO.deleteBucketList(bucketListId);
    }
}
