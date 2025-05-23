package com.example.madang_project.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid", nullable = false)
    private Integer id;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ColumnDefault("100")
    @Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "bookid")
//    @JsonManagedReference
    private List<OrderEntity> orders = new ArrayList<>();
}