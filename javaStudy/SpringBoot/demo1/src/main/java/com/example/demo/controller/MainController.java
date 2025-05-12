package com.example.demo.controller;

import com.example.demo.data.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {
    @GetMapping(value = "/hello")
    public String hello() {
//        return "index.html";
        return "헬로";
    }

    @GetMapping(value = "/variable/{var}")
    public String variable(@PathVariable("var") String var) {
        return var;
    }

    @GetMapping(value = "/request")
    public String request(@RequestParam String name, @RequestParam int age, @RequestParam String addr) {
        return name + " " + age + " " + addr;
    }

    @GetMapping(value = "/request2")
    public String request2(@RequestParam Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "<br>");
        }
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String request3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
