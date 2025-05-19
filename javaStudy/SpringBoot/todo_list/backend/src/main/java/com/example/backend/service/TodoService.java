package com.example.backend.service;

import com.example.backend.data.dao.TodoDAO;
import com.example.backend.data.dto.TodoDTO;
import com.example.backend.data.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    public final TodoDAO todoDAO;

    public List<TodoDTO> getAllTodos() {
        List<TodoDTO> todoDTOList = new ArrayList<>();
        List<Todo> todos = this.todoDAO.getAllTodos();
        for (Todo todo : todos) {
            TodoDTO todoDTO = TodoDTO.builder()
                    .id(todo.getId())
                    .content(todo.getContent())
                    .build();
            todoDTOList.add(todoDTO);
        }
        return todoDTOList;
    }

    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = this.todoDAO.saveTodo(todoDTO.getContent(),
                LocalDateTime.now(), "생성");
        TodoDTO savetodoDTO = TodoDTO.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .build();
        return savetodoDTO;
    }

    public boolean deleteTodoById(Integer id) {
        return this.todoDAO.deleteTodoById(id);
    }
}
