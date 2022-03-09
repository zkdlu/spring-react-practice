package com.zkdlu.todo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {
    @Id @GeneratedValue
    private Long id;
    private String content;
    private boolean complete;

    public Todo(Long id, String content, boolean complete) {
        this.id = id;
        this.content = content;
        this.complete = complete;
    }

    public Todo(String content, boolean complete) {
        this(null, content, complete);
    }

    public void update(boolean complete) {
        this.complete = complete;
    }
}
