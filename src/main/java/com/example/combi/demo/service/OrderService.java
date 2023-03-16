package com.example.combi.demo.service;

import com.example.combi.demo.model.Order;
import com.example.combi.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public List<Order> findOrders(){
        return orderRepository.findAll();
    }
}
