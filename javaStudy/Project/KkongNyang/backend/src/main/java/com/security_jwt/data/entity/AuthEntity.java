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
@Table(name = "authentbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthEntity {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", length = 45)
    private String role;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "realname", nullable = false, length = 45)
    private String realname;

}