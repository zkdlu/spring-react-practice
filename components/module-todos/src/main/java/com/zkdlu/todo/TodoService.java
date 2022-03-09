package com.zkdlu.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static long id = 1;
    private static final List<Todo> todoRepository = new ArrayList<>();

    public void createTodo(TodoRequest todoRequest) {
        todoRepository.add(
                new Todo(id++, todoRequest.getContent(), false)
        );
    }

    public List<Todo> getTodos() {
        return todoRepository;
    }

    public void updateTodo(Long id, boolean complete) {
        Todo findTodo = getTodo(id);

        findTodo.update(complete);
    }

    public void deleteTodo(Long id) {
        Todo findTodo = getTodo(id);

        todoRepository.remove(findTodo);
    }

    private Todo getTodo(Long id) {
        Todo findTodo = todoRepository.stream().filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return findTodo;
    }
}
