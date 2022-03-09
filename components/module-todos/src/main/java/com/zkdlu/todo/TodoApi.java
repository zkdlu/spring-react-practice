package com.zkdlu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "todos")
public class TodoApi {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTodo(@RequestBody TodoRequest todoRequest) {
        todoService.createTodo(todoRequest);
    }

    @PatchMapping("{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody TodoUpdateRequest updateRequest) {
        todoService.updateTodo(id, updateRequest.isComplete());
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
