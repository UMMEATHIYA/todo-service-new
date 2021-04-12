package com.example.todoservice.rest;

import com.example.todoservice.model.Todo;
import com.example.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("status up.");
    }
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos()
    {
        return ResponseEntity.ok(todoService.getAllTodos());
    }
}