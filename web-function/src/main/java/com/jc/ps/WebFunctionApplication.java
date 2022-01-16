package com.jc.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootApplication
public class WebFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFunctionApplication.class, args);
    }

    List<TollStation> tollStations;

    public WebFunctionApplication() {
        tollStations = new ArrayList<>();
        tollStations.add(new TollStation("100A", 112.5f, 2));
        tollStations.add(new TollStation("111C", 124f, 4));
        tollStations.add(new TollStation("112C", 126f, 2));
    }

    @Bean
    public Function<String, TollStation> retrieveStation() {
        return value -> {
            log.info("received request for station - {}", value);
            return tollStations.stream()
                .filter(toll -> value.equals(toll.getStationId()))
                .findAny()
                .orElse(null);
        };
    }

	@Bean
    public Consumer<TollRecord> processTollRecord() {
        return value -> {
            log.info("received toll for car with license plate - {}", value.getLicensePlate());
        };
    }

    @Bean
    public Function<TollRecord, Mono<Void>> processTollRecordReactive() {
        return value -> {
            log.info("received reactive toll for car with license plate - {}", value.getLicensePlate());
            return Mono.empty();
        };
    }

    @Bean
    public Consumer<Flux<TollRecord>> processListOfTollRecordsReactive() {
        return value -> {
            value.subscribe(toll -> log.info("Received Flux toll for car with license plate - {}", toll.getLicensePlate()));
        };
    }

    @Bean
    public Supplier<Flux<TollStation>> getTollStations() {
        return () -> Flux.fromIterable(tollStations);
    }

}
