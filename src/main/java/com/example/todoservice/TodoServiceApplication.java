package com.example.todoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todoservice.model.Todo;
import com.example.todoservice.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TodoServiceApplication implements CommandLineRunner {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        todoRepository.save(new Todo(1,"compile",true));
        todoRepository.save(new Todo(2,"testing",true));
        todoRepository.save(new Todo(3,"debug",false));
        todoRepository.save(new Todo(4,"deploy",false));
    }
}
