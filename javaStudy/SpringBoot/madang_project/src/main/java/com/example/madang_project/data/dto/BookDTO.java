package com.example.madang_project.data.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer id;
    private String bookName;
    private String publisher;
    @Min(value = 0)
    private Integer price;
    @Min(value = 0)
    private Integer stock;
}
