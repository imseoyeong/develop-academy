package com.example.backend.controller;

import com.example.backend.data.dto.TodoDTO;
import com.example.backend.data.repository.TodoRepository;
import com.example.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping(value = "/todo-list")
    public ResponseEntity<List<TodoDTO>> getTodoList() {
        List<TodoDTO> todoDTOList = this.todoService.getAllTodos();
        return ResponseEntity.ok(todoDTOList);
    }

    @PostMapping(value = "/add-todo")
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodoDTO = this.todoService.saveTodo(todoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodoDTO);
    }

    @DeleteMapping(value = "/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        boolean result = this.todoService.deleteTodoById(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("TODO 삭제 성공");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TODO 삭제 실패");
    }
}
