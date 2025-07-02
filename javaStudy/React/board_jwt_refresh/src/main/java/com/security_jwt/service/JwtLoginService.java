package com.security_jwt.service;

import com.security_jwt.data.dao.AuthDAO;
import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.jwt.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtLoginService implements UserDetailsService {
    private final AuthDAO authDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthEntity authEntity = this.authDAO.findUserByUsername(username);
        if(authEntity == null) {
            throw new UsernameNotFoundException("User not found" + username);
        }

//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(authEntity.getRole()));
//        return new User(authEntity.getUsername(), authEntity.getPassword(), grantedAuthorities);

        return new CustomUserDetails(authEntity); //User와 마찬가지로 UserDetails를 상속받았으므로 가능함
    }
}
