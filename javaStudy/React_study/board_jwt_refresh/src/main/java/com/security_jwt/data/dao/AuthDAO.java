package com.security_jwt.data.dao;

import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDAO {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean exsistUserName(String userName) {
        return authRepository.existsByUsername(userName);
    }

    public AuthEntity saveUser(String userName, String password, String userfullname, String role) {
        AuthEntity authEntity = AuthEntity.builder()
                .username(userName)
                .password(this.passwordEncoder.encode(password))
                .userfullname(userfullname)
                .role(role).build();
        return authRepository.save(authEntity);
    }

    public AuthEntity findUserByUsername(String userName) {
        return authRepository.findByUsername(userName);
    }
}
