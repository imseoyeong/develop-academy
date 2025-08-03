package com.security_jwt.data.dao;

import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.ProfileEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.data.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthDAO {
    private final AuthRepository authRepository;
    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthEntity authSave(String username, String pasword, String realname, String gender, LocalDate birthday) {

        if(this.authRepository.existsByUsername(username)) {
            return null;
        }
        AuthEntity authEntity = AuthEntity.builder()
                .username(username)
                .password(this.passwordEncoder.encode(pasword))
                .gender(gender)
                .birthday(birthday)
                .realname(realname)
                .role("ROLE_USER")
                .build();
        return this.authRepository.save(authEntity);
    }

    public ProfileEntity profileSave(String username, String profileimg, String nickname) {
        if(this.profileRepository.existsById(username)) {
            return null;
        }

        ProfileEntity profileEntity = ProfileEntity.builder()
                .username(username)
                .nickname(nickname)
                .profileimage(profileimg)
                .build();

        return this.profileRepository.save(profileEntity);
    }

}
