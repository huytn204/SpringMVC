package com.example.shopperspringmvc.controller;


import com.example.shopperspringmvc.entity.Customer;
import com.example.shopperspringmvc.rep.CustomerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRep customerRep;

    @GetMapping
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerRep.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }
}
