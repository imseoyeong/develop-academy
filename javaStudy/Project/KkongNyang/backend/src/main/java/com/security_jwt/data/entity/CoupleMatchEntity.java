package com.security_jwt.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "couplematchtbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoupleMatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "part1", nullable = false)
    private AuthEntity part1;

    @Column(name="part1nickname")
    private String part1nickname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "part2", nullable = false)
    private AuthEntity part2;

    @Column(name="part2nickname")
    private String part2nickname;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "profileimage")
    private String profileimage;

    @Lob
    @Column(name = "couplestory")
    private String couplestory;

    @Column(name = "firstday")
    private LocalDate firstday;

}