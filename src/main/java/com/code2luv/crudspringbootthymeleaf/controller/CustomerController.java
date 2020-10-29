package com.code2luv.crudspringbootthymeleaf.controller;

import com.code2luv.crudspringbootthymeleaf.model.Customer;
import com.code2luv.crudspringbootthymeleaf.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getCustomerList(Model model){

        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerlist",customerList);

        return "customers/customer-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer tempCustomer = new Customer();

        theModel.addAttribute("customer", tempCustomer);

        return "customers/customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId, Model model){

        Customer tempCustomer = customerService.findById(theId);
        model.addAttribute("customer", tempCustomer);

        return "customers/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer tempCustomer) {

        // save the employee
        customerService.save(tempCustomer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId){

        customerService.deleteById(theId);

        return "redirect:/customers/list";
    }


}
