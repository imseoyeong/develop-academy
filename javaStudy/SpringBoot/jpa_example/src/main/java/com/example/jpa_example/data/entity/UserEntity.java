package com.example.jpa_example.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usertbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @Column(name = "userid", nullable = false, length = 8)
    private String userid;

    @Column(name = "username")
    private String username;

    @Column(name = "birthyear", nullable = false)
    private Integer birthyear;

    @Column(name = "addr")
    private String addr;

    @Column(name = "mobile1")
    private String mobile1;

    @Column(name = "mobile2")
    private String mobile2;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "mdate")
    private Date mdate;

}