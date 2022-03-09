package com.zkdlu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public void createTodo(TodoRequest todoRequest) {
        todoRepository.save(
                new Todo(todoRequest.getContent(), false)
        );
    }

    @Transactional(readOnly = true)
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Transactional
    public void updateTodo(Long id, boolean complete) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        findTodo.update(complete);
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        todoRepository.delete(findTodo);
    }
}
