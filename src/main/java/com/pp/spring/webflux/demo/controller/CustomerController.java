package com.pp.spring.webflux.demo.controller;

import com.pp.spring.webflux.demo.dto.Customer;
import com.pp.spring.webflux.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<Customer> loadAllCustomers(){
        return service.getCustomers();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> loadAllCustomersStream(){
        return service.getCustomersStream();
    }
}
