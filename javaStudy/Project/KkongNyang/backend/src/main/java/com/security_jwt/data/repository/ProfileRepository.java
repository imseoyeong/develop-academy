package com.security_jwt.data.repository;

import com.security_jwt.data.entity.ProfileEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {
    List<ProfileEntity> findAllByCouplecode(String couplecode);
}
