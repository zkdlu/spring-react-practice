package com.zkdlu.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping("/api/test")
    public String hello() {
        return "Hello World";
    }
}
