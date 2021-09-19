package com.pp.spring.webflux.demo.service;

import com.pp.spring.webflux.demo.dao.CustomerDao;
import com.pp.spring.webflux.demo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> getCustomers(){
        return dao.getCustomers();
    }

    public Flux<Customer> getCustomersStream(){
        return dao.getCustomerStream();
    }
}
