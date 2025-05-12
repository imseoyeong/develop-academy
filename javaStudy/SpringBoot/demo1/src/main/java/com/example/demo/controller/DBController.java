package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.data.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DBController {
    private final UserRepository userRepository;

    @GetMapping(value = "/userlist")
    public List<User> getUserList() {
        List<User> userlist = this.userRepository.findAll();
        return userlist;
    }
}
