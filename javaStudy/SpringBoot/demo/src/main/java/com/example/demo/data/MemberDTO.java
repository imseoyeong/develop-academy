package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 접근자를 자동으로 추가해준다.
@AllArgsConstructor // 생성자를 추가시키는 기능
@NoArgsConstructor // 전달하지 않아도 만들어지는?..
public class MemberDTO { // DTO: Data Transfer Object 데이터를 담을 틀(바구니)
    private String name;
    private int age;
    private String email;
}
