package com.example.jpa_example.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
    private String userid;
    @NotEmpty(message = "이름은 비어있을 수 없습니다.")
    private String username;
    private Integer birthyear;
    private String addr;
    private String mobile1;
    private String mobile2;
    @Min(value = 100, message = "키는 100 이상이어야 합니다.")
    private Integer height;
    private Date mdate;
}
