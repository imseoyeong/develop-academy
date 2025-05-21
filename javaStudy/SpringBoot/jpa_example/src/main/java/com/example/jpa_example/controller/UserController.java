package com.example.jpa_example.controller;

import com.example.jpa_example.data.dto.UserDTO;
import com.example.jpa_example.data.entity.BuyEntity;
import com.example.jpa_example.data.entity.UserEntity;
import com.example.jpa_example.data.repository.BuyEntityRepository;
import com.example.jpa_example.data.repository.UserEntityRepository;
import com.example.jpa_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping(value = "/userinfo")
public class UserController {
//    private final UserEntityRepository userRepository;
    private final UserService userService;
    private final BuyEntityRepository buyEntityRepository;

    // 모든 유저 정보
    @GetMapping(value = "user-list")
    public List<UserDTO> getUserList() {
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "addr/{addr}")
    public List<UserDTO> userByAddr(@PathVariable("addr") String addr) {
        return this.userService.findUsersByAddr(addr);
    }

    @GetMapping(value = "birthyear/{birthyear}")
    public List<UserDTO> userByBirthyear(@PathVariable("birthyear") Integer birthyear) {
        return this.userService.findUsersByBirthyear(birthyear);
    }

    @GetMapping(value = "addr-birthyear")
    public List<UserDTO> usersByAddrAndBirthyear(@RequestParam Integer birthyear,
                                     @RequestParam String addr) {
        return this.userService.findUsersByAddrAndBirthyear(addr, birthyear);
    }



//    // usertbl 정보 다 가져오기
//    @GetMapping(value = "user-list")
//    public List<UserEntity> userList() {
//        return this.userRepository.findAll();
//    }
//
//    // buytbl 정보 다 가져오기
//    @GetMapping(value = "/buy-list")
//    public List<BuyEntity> buyList() {
//        return this.buyEntityRepository.findAll();
//    }
//
//    // 특정 주소지인 유저 찾기
//    @GetMapping(value = "addr/{addr}")
//    public List<UserEntity> userInfo(@PathVariable("addr") String addr) {
//        return this.userRepository.searchUserInfo(addr);
//    }
//
//    // 특정 태어난 년도 찾기
//    @GetMapping(value = "birthyear/{birthyear}")
//    public List<UserEntity> userinfo(@PathVariable("birthyear") Integer birthyear) {
//        return this.userRepository.searchUserInfo(birthyear);
//    }
//
//    @GetMapping(value = "addr-birthyear")
//    public List<UserEntity> userInfo(@RequestParam Integer birthyear,
//                                     @RequestParam String addr) {
//        return this.userRepository.searchUserInfo(addr, birthyear);
//    }
}
