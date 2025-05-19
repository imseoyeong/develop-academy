package com.example.backend.data.dao;

import com.example.backend.data.entity.Todo;
import com.example.backend.data.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoDAO {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return this.todoRepository.findAll();
    }

    public Todo saveTodo(String content, LocalDateTime created, String description){
        Todo todo = Todo.builder()
                .content(content)
                .created(created)
                .description(description)
                .build();
        return this.todoRepository.save(todo);
    }

    public boolean deleteTodoById(Integer id){
        if(this.todoRepository.existsById(id)){
            this.todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
