package com.example.shopperspringmvc.controller;


import com.example.shopperspringmvc.entity.Order;
import com.example.shopperspringmvc.rep.OrderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRep orderRep;

    @GetMapping
    public String getAllCustomers(Model model) {
        List<Order> orders = orderRep.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
