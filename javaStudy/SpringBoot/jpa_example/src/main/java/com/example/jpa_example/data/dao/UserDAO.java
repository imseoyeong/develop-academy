package com.example.jpa_example.data.dao;

import com.example.jpa_example.data.entity.UserEntity;
import com.example.jpa_example.data.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDAO {
    private final UserEntityRepository userEntityRepository;

    public List<UserEntity> getAllUsers() {
        return this.userEntityRepository.findAll();
    }

    public List<UserEntity> findUsersByAddr(String addr) {
        return this.userEntityRepository.searchUserInfo(addr);
    }

    public List<UserEntity> findUsersByBirthyear(Integer birthyear) {
        return this.userEntityRepository.searchUserInfo(birthyear);
    }

    public List<UserEntity> findUserByAddrAndBirthyear(String addr, Integer birthyear) {
        return this.userEntityRepository.searchUserInfo(addr, birthyear);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return this.userEntityRepository.save(userEntity);
    }
}
