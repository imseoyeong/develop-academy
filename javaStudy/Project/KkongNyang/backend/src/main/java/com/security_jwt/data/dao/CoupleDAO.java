package com.security_jwt.data.dao;

import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.data.entity.ProfileEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.data.repository.CoupleMatchRepository;
import com.security_jwt.data.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoupleDAO {

    private final ProfileRepository profileRepository;
    private final CoupleMatchRepository coupleMatchRepository;
    private final AuthRepository authRepository;

    public ProfileEntity findByCoupleCode(String coupleCode) {
        List<ProfileEntity> profileEntityList = this.profileRepository.findAllByCouplecode(coupleCode);
        return profileEntityList.get(0);
    }

    public ProfileEntity saveCoupleCode(String username, String coupleCode) {
        ProfileEntity profile = profileRepository.findById(username).orElse(null);
        if (profile != null) {
            profile.setCouplecode(coupleCode);
            return profileRepository.save(profile);
        }
        return null;
    }

    public CoupleMatchEntity matchCouple(String username1, String username2, String code) {
        Optional<AuthEntity> user1Opt = authRepository.findById(username1);
        Optional<AuthEntity> user2Opt = authRepository.findById(username2);

        if (user1Opt.isPresent() && user2Opt.isPresent()) {
            AuthEntity user1 = user1Opt.get();
            AuthEntity user2 = user2Opt.get();

            CoupleMatchEntity coupleMatch = CoupleMatchEntity.builder()
                    .part1(user1)
                    .part2(user2)
                    .code(code)
                    .build();
            return coupleMatchRepository.save(coupleMatch);
        }
        return null;
    }
}
