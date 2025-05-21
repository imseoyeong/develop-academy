package com.example.jpa_example.controller;

import com.example.jpa_example.data.entity.BuyEntity;
import com.example.jpa_example.data.entity.UserEntity;
import com.example.jpa_example.data.repository.BuyEntityRepository;
import com.example.jpa_example.data.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserEntityRepository userRepository;
    private final BuyEntityRepository buyEntityRepository;

    // usertbl 정보 다 가져오기
    @GetMapping(value = "/user-list")
    public List<UserEntity> userList() {
        return this.userRepository.findAll();
    }

    // buytbl 정보 다 가져오기
    @GetMapping(value = "/buy-list")
    public List<BuyEntity> buyList() {
        return this.buyEntityRepository.findAll();
    }

    // 특정 주소지인 유저 찾기
    @GetMapping(value = "/userinfo/{addr}")
    public List<UserEntity> userInfo(@PathVariable("addr") String addr) {
        return this.userRepository.searchUserInfo(addr);
    }

    // 특정 태어난 년도 찾기
//    @GetMapping(value = "/userinfo/{birthyear}")
//    public List<UserEntity> userInfo(@PathVariable("birthyear") Integer birthyear) {
//        return this.userRepository.searchUserInfo(birthyear);
//    }

    @GetMapping(value = "/userinfo")
    public List<UserEntity> userInfo(@RequestParam Integer birthyear) {
        return this.userRepository.searchUserInfo(birthyear);
    }

    @GetMapping(value = "/userinfo/info")
    public List<UserEntity> userInfo(@RequestParam Integer birthyear,
                                     @RequestParam String addr) {
        return this.userRepository.searchUserInfo(addr, birthyear);
    }
}
