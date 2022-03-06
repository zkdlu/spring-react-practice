package com.zkdlu.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomToken {
    private String auth;
    private String refresh;

    public CustomToken(String auth, String refresh) {
        this.auth = auth;
        this.refresh = refresh;
    }
}
