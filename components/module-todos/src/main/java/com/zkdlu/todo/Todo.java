package com.zkdlu.todo;

import lombok.Getter;

@Getter
public class Todo {
    private long id;
    private String content;
    private boolean complete;

    public Todo(long id, String content, boolean complete) {
        this.id = id;
        this.content = content;
        this.complete = complete;
    }

    public void update(boolean complete) {
        this.complete = complete;
    }
}
