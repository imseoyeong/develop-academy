package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.data.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DBController {
    private final UserRepository userRepository;
    // RequiredArgsConstructor을 넣었기 때문에 작성하지 않아도 된다.
//    public DBController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    // 전체 정보 가져오는 것
    @GetMapping(value = "/userlist")
    public List<User> getUserList() {
        List<User> userlist = this.userRepository.findAll(); //select from * usertbl 대신 하는 문
        return userlist;
    }

    // 프라이머리키를 이용 해 id를 들고온 것
    @GetMapping(value = "/userlist/{id}")
    public User getUser(@PathVariable String id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return user.get(); //Optional이 감싸고 있는 User 객체만 들고온다?
        }
        return null;
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping(value = "/user/{var}")
    public String deleteUser(@PathVariable String var) {
        if (this.userRepository.existsById(var)) {
            this.userRepository.deleteById(var);
            return "Delete Success";
        }
        return "Delete Fail";
    }
}
