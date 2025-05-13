package com.example.demo.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id // 프라이머리키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 설정
    private Integer bookid;
    private String bookname;
    private String publisher;
    private Integer price;
}
