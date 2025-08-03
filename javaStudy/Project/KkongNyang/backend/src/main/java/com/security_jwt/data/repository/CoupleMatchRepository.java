package com.security_jwt.data.repository;

import com.security_jwt.data.entity.CoupleMatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoupleMatchRepository extends JpaRepository<CoupleMatchEntity, Integer> {
    Optional<CoupleMatchEntity> findByCode(String code);
    void deleteByCode(String code);
}
