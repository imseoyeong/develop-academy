package com.security_jwt.data.dao;

import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.data.entity.ProfileEntity;
import com.security_jwt.data.repository.CoupleMatchRepository;
import com.security_jwt.data.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoupleProfileDAO {

    private final CoupleMatchRepository coupleMatchRepository;
    private final ProfileRepository profileRepository;

    public Optional<CoupleMatchEntity> findCoupleMatchByCode(String coupleCode) {
        return coupleMatchRepository.findByCode(coupleCode);
    }

    public CoupleMatchEntity updateCoupleProfile(CoupleMatchEntity coupleMatchEntity) {
        return coupleMatchRepository.save(coupleMatchEntity);
    }

    @Transactional
    public void deleteCouple(String coupleCode) {

        List<ProfileEntity> deleteCouple = this.profileRepository.findAllByCouplecode(coupleCode);

        // profiletbl에서 couplecode 삭제
        deleteCouple.forEach(profileEntity -> {
            profileEntity.setCouplecode(null);
            profileRepository.save(profileEntity);
        });

        // couplematchtbl에서 레코드 삭제
        coupleMatchRepository.deleteByCode(coupleCode);
    }

    public Optional<ProfileEntity> findProfileByUsername(String username) {
        return profileRepository.findById(username);
    }

    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }
}
