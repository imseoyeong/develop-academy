package com.example.madang_project.data.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer orderid;
    private Integer custid;
    private Integer bookid;
    private Integer saleprice;
    private LocalDate orderdate;
}
