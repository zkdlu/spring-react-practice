package com.zkdlu.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "todos")
public class TodoApi {
    @GetMapping
    public List<Todo> getTodos() {
        return List.of(
                new Todo(1, "content", true)
        );
    }
}
