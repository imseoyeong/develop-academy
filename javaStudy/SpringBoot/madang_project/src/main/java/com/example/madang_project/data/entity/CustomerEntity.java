package com.example.madang_project.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    @Column(name = "phone", length = 13)
    private String phone;

    @ColumnDefault("'bronze'")
    @Column(name = "grade", length = 10)
    private String grade;

    @OneToMany(mappedBy = "custid")
//    @JsonManagedReference
    private Set<OrderEntity> orders = new LinkedHashSet<>();

}