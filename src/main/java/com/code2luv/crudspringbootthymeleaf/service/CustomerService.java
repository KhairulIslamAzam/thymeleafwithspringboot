package com.code2luv.crudspringbootthymeleaf.service;

import com.code2luv.crudspringbootthymeleaf.model.Customer;
import java.util.List;

public interface CustomerService {

     List<Customer> findAll();

     void save(Customer customer);

     Customer findById(int id);

     void deleteById(int id);

    // List<Customer> searchCustomers(String searchName);
}
