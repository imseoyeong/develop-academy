package com.security_jwt.data.repository;

import com.security_jwt.data.entity.BucketListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BucketListRepository extends JpaRepository<BucketListEntity, Integer> {
    @Modifying
    @Query("DELETE FROM BucketListEntity b WHERE b.code.code = :coupleCode AND b.completedDate IS NOT NULL")
    void deleteCompletedByCoupleCode(@Param("coupleCode") String coupleCode);
}
