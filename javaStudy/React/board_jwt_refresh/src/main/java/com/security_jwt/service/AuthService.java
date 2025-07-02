package com.security_jwt.service;

import com.security_jwt.data.dao.AuthDAO;
import com.security_jwt.data.dto.AuthDTO;
import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.exception.DuplicateIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthDAO authDAO;

    public AuthDTO join(AuthDTO authDTO) {
        if(!this.authDAO.exsistUserName(authDTO.getUsername())) {
            AuthEntity user = this.authDAO.saveUser(authDTO.getUsername(),authDTO.getPassword(), authDTO.getUserFullName(),"ROLE_USER");
            AuthDTO newAuthDTO = AuthDTO.builder()
                    .username(user.getUsername())
                    .userFullName(user.getUserfullname()).build();
            return newAuthDTO;
        }
        throw new DuplicateIdException("Username already exists");
    }
}
