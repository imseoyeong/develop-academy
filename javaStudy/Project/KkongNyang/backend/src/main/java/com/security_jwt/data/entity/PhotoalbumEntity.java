package com.security_jwt.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "photoalbumtbl")
public class PhotoalbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code", nullable = false, referencedColumnName = "code")
    private CoupleMatchEntity code;

    @Column(name = "img", nullable = false)
    private String img;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "story", nullable = false)
    private String story;

}