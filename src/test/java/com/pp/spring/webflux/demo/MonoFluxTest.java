package com.pp.spring.webflux.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void monoTest(){
        Mono<?> monoStr = Mono.just("javatechie")
                .then(Mono.error(new RuntimeException("exception occured")))
                .log();
        monoStr.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void fluxTest(){
        Flux<String> fluxStr = Flux.just("spring", "java", "hibernate", "jdbc")
                .concatWithValues("aws")
                .concatWith(Flux.error(new RuntimeException("exception occured")))
                .log();
        fluxStr.subscribe(System.out::println,(e) -> System.out.println(e.getMessage()));
    }
}
