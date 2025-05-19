package com.example.test_store_backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//entity 클래스
@Entity
@Table(name = "producttbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer price;
    private String imagesrc;
    private LocalDateTime created; // 생성 또는 수정된 시간을 저장
    private String description; // 생성인지 수정인지 나타내는 설명글
}
