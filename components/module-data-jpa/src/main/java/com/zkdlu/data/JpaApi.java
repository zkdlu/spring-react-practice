package com.zkdlu.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/jpa")
public class JpaApi {
    @GetMapping
    public void test() {

    }
}
