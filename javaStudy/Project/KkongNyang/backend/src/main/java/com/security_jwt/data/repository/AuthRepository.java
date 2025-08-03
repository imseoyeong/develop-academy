package com.security_jwt.data.repository;


import com.security_jwt.data.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, String> {
    AuthEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
