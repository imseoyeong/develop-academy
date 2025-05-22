package com.example.jpa_example.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuyDTO {
    private Integer id;
    @NotEmpty(message = "아이디는 비어있을 수 없습니다.")
    private String userid;
    private String prodname;
    private String groupname;
    private Integer price;
    @Min(value = 1, message = "수량은 1 이상이어야 합니다.")
    private Short amount;
}
