package com.code2luv.crudspringbootthymeleaf.service;

import com.code2luv.crudspringbootthymeleaf.model.Customer;
import com.code2luv.crudspringbootthymeleaf.dao.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
         customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer tempCustomer = null;

        if(result.isPresent()){
            tempCustomer = result.get();
        }else {
            throw new RuntimeException("Could not found id "+id);
        }

        return tempCustomer;
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);

    }
}
