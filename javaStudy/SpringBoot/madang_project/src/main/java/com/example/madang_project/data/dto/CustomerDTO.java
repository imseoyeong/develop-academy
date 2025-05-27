package com.example.madang_project.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer custid;
    private String name;
    private String address;
    private String phone;
    private List<OrderInfoDTO> orders;
}
