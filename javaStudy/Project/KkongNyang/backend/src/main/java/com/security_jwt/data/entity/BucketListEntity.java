package com.security_jwt.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "bucketlisttbl")
@AllArgsConstructor
@NoArgsConstructor
public class BucketListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code", nullable = false, referencedColumnName = "code")
    private CoupleMatchEntity code;

    @Column(name = "todo", nullable = false)
    private String todo;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

}