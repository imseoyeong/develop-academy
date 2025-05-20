package com.demo_todo.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ToDoDTO {
    private Integer id;
    @NotEmpty(message = "내용은 비어있을 수 없습니다.")
    private String title;
    private boolean completed;
}
