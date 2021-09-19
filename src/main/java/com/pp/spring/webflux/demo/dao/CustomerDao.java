package com.pp.spring.webflux.demo.dao;

import com.pp.spring.webflux.demo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void getSleep(int i) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }

    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,10)
                .peek(CustomerDao::getSleep)
                .peek(i -> System.out.println("Processing count : "+i))
                .mapToObj(i -> new Customer(i, "Customer-"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream(){
        return Flux.range(1,20)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count in stream : "+i))
                .map(i -> new Customer(i, "Customer"+i));
    }
}
