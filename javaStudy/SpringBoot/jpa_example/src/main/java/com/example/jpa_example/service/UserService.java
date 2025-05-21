package com.example.jpa_example.service;

import com.example.jpa_example.data.dao.UserDAO;
import com.example.jpa_example.data.dto.UserDTO;
import com.example.jpa_example.data.entity.UserEntity;
import com.example.jpa_example.data.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> users = this.userDAO.getAllUsers();
        for (UserEntity user : users) {
            UserDTO dto = UserDTO.builder()
                    .addr(user.getAddr())
                    .userid(user.getUserid())
                    .username(user.getUsername())
                    .birthyear(user.getBirthyear())
                    .mobile1(user.getMobile1())
                    .mobile2(user.getMobile2())
                    .height(user.getHeight())
                    .mdate(user.getMdate())
                    .build();
            userDTOList.add(dto);
        }
        return userDTOList;
    }

    public List<UserDTO> findUsersByAddr(String addr) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> users = this.userDAO.findUsersByAddr(addr);
        for (UserEntity user : users) {
            UserDTO dto = UserDTO.builder()
                    .addr(user.getAddr())
                    .userid(user.getUserid())
                    .username(user.getUsername())
                    .birthyear(user.getBirthyear())
                    .mobile1(user.getMobile1())
                    .mobile2(user.getMobile2())
                    .height(user.getHeight())
                    .mdate(user.getMdate())
                    .build();
            userDTOList.add(dto);
        }
        return userDTOList;
    }

    public List<UserDTO> findUsersByBirthyear(Integer birthyear) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> users = this.userDAO.findUsersByBirthyear(birthyear);
        for (UserEntity user : users) {
            UserDTO dto = UserDTO.builder()
                    .addr(user.getAddr())
                    .userid(user.getUserid())
                    .username(user.getUsername())
                    .birthyear(user.getBirthyear())
                    .mobile1(user.getMobile1())
                    .mobile2(user.getMobile2())
                    .height(user.getHeight())
                    .mdate(user.getMdate())
                    .build();
            userDTOList.add(dto);
        }
        return userDTOList;
    }

    public List<UserDTO> findUsersByAddrAndBirthyear(String addr, Integer birthyear) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> users = this.userDAO.findUserByAddrAndBirthyear(addr, birthyear);
        for (UserEntity user : users) {
            UserDTO dto = UserDTO.builder()
                    .addr(user.getAddr())
                    .userid(user.getUserid())
                    .username(user.getUsername())
                    .birthyear(user.getBirthyear())
                    .mobile1(user.getMobile1())
                    .mobile2(user.getMobile2())
                    .height(user.getHeight())
                    .mdate(user.getMdate())
                    .build();
            userDTOList.add(dto);
        }
        return userDTOList;
    }
}
