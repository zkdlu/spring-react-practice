package com.zkdlu.cloud;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ServerInstance {
    private final String id;
    private final String name;
    private final String url;
//    "instanceId": "192.168.0.12:cloud-service-demo:9000",
//            "app": "CLOUD-SERVICE-DEMO",
//            "appGroupName": null,
//            "ipAddr": "192.168.0.12",
//            "sid": "na",
//            "homePageUrl": "http://192.168.0.12:9000/",
//            "statusPageUrl": "http://192.168.0.12:9000/actuator/info",
//            "healthCheckUrl": "http://192.168.0.12:9000/actuator/health",
//            "secureHealthCheckUrl": null,
//            "vipAddress": "cloud-service-demo",
//            "secureVipAddress": "cloud-service-demo",

    public ServerInstance(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public static ServerInstance empty() {
        return new ServerInstance("", "", "");
    }
}
