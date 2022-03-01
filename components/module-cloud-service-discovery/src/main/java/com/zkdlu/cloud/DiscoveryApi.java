package com.zkdlu.cloud;

import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Lazy
@RequiredArgsConstructor
@RestController
public class DiscoveryApi {
    private final PeerAwareInstanceRegistry registry;
    private final DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public List<String> getServices() {
        Applications applications = registry.getApplications();
        return applications.getRegisteredApplications()
                .stream()
                .map(Application::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/services/{serviceName}")
    public List<ServerInstance> getInstance(@PathVariable String serviceName) {
        List<Application> applications = registry.getApplications().getRegisteredApplications();
        Application app = applications.stream()
                .filter(application -> application.getName().equals(serviceName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return app.getInstances()
                .stream()
                .map(instance -> new ServerInstance(instance.getInstanceId(), instance.getAppName(),instance.getHomePageUrl()))
                .collect(Collectors.toList());
    }
}
