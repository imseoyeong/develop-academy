package com.example.madang_project.data.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer orderid;
    private Integer custid;
    private Integer bookid;
    @Min(value = 0)
    private Integer saleprice;
    private Date orderdate;
}
