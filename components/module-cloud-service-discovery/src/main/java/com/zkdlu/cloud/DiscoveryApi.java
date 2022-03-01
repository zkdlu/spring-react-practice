package com.zkdlu.cloud;

import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class DiscoveryApi {
    private final PeerAwareInstanceRegistry registry;

    @GetMapping("/services")
    public List<String> getServices() {
        Applications applications = registry.getApplications();
        return applications.getRegisteredApplications()
                .stream()
                .map(Application::getName)
                .collect(Collectors.toList());
    }
}
