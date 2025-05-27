package com.example.madang_project.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoDTO {
    private Integer orderid;
    private String custname;
    private String bookname;
    private Integer saleprice;
    private LocalDate orderdate;
}
