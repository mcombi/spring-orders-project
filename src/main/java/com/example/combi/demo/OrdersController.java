package com.example.combi.demo;

import com.example.combi.demo.model.Order;
import com.example.combi.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/order")
    public List<Order> getOrders(){
        return orderService.findOrders();
    }
}
