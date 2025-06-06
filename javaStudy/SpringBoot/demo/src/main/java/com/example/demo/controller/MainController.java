package com.example.demo.controller;

import com.example.demo.data.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // @Contrlloer 와 @ResponseBody를 합친 것
public class MainController {
    @GetMapping(value = "/hello")
    public String hello() {
//        return "index.html";
        return "hello world";
    }

    @GetMapping(value = "/variable/{var}")
    public String variable(@PathVariable("var") String var) {
        return var;
    }

    @GetMapping(value = "/request")
    public String request(@RequestParam String name,
                          @RequestParam int age,
                          @RequestParam String email) {
        return name + " " + age + " " + email;
    }

    @GetMapping(value = "/request2")
    public StringBuffer request2(@RequestParam Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "<br>");
        }
        return sb;
    }

    @GetMapping(value = "/request3")
    public String request3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
