package com.security_jwt.data.dao;

import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.ProfileEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.data.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyInfoDAO {
    private final AuthRepository authRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean checkPassword(String username, String password) {
        AuthEntity authEntity = authRepository.findByUsername(username);
        return passwordEncoder.matches(password, authEntity.getPassword());
    }

    public void updateProfile(String username, String nickname, String profileImage) {
        ProfileEntity profileEntity = profileRepository.findById(username).orElse(null);
        if (nickname != null) {
            profileEntity.setNickname(nickname);
        }
        if (profileImage != null) {
            profileEntity.setProfileimage(profileImage);
        }
        profileRepository.save(profileEntity);
    }

    public void updateAuth(String username, String gender, String birthday, String newPassword) {
        AuthEntity authEntity = authRepository.findByUsername(username);
        if (gender != null) {
            authEntity.setGender(gender);
        }
        if (birthday != null) {
            authEntity.setBirthday(java.time.LocalDate.parse(birthday));
        }
        if (newPassword != null) {
            authEntity.setPassword(passwordEncoder.encode(newPassword));
        }
        authRepository.save(authEntity);
    }

    public AuthEntity getAuthEntity(String username) {
        return authRepository.findByUsername(username);
    }

    public ProfileEntity getProfileEntity(String username) {
        return profileRepository.findById(username).orElse(null);
    }
}
