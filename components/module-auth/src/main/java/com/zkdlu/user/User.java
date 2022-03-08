package com.zkdlu.user;

import lombok.Getter;

@Getter
public class User {
    private final String email;
    private final String name;
    private final String thumbnail;

    public User(String email, String name, String thumbnail) {
        this.email = email;
        this.name = name;
        this.thumbnail = thumbnail;
    }
}
