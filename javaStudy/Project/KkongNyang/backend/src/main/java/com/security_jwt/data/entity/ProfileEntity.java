package com.security_jwt.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "profiletbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileEntity {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "profileimage")
    private String profileimage;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "couplecode")
    private String couplecode;

    }