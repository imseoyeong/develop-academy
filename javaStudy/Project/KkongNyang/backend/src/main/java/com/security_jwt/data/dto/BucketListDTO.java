package com.security_jwt.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketListDTO {
    private Integer id;
    private String todo;
    private LocalDateTime createdDate;
    private LocalDateTime completedDate;
}
