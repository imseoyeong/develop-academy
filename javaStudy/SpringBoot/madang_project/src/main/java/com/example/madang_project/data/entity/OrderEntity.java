package com.example.madang_project.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false)
    private Integer orderid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custid", nullable = false)
    private CustomerEntity cust;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookid", nullable = false)
    private BookEntity book;

    @NotNull
    @Column(name = "saleprice", nullable = false)
    private Integer saleprice;

    @NotNull
    @Column(name = "orderdate", nullable = false)
    private LocalDate orderdate;
}