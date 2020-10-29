package com.code2luv.crudspringbootthymeleaf.dao;

import com.code2luv.crudspringbootthymeleaf.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    //no need to any implementation
}

