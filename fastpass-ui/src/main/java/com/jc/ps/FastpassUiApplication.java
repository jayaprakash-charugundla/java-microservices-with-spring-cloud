package com.jc.ps;

import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@LoadBalancerClient(name = "fastpass-service", configuration = LoadBalancerAlgorithmConfig.class)
@SpringBootApplication
public class FastpassUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastpassUiApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public Supplier<FastPassToll> generateTollCharge() {
        return () -> new FastPassToll("800", "1001", 1.05f);
    }
}
