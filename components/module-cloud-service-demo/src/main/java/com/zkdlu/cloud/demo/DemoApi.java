package com.zkdlu.cloud.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DemoApi {
    @Lazy
    private final DiscoveryClient discoveryClient;

    @GetMapping("/")
    public List<String> demo() {
        return discoveryClient.getServices();
    }
}
