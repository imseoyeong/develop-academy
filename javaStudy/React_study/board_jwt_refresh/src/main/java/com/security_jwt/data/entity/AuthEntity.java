package com.security_jwt.data.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "role")
    private String role;

    @Column(name="userfullname")
    private String userfullname;

}