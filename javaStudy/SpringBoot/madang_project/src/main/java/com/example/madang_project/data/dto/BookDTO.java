package com.example.madang_project.data.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer bookid;
    private String bookname;
    private String publisher;
    private Integer price;
    private List<OrderInfoDTO> orders;
}
