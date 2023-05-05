package com.example.combi.demo.service;


import com.example.combi.demo.model.Order;
import com.example.combi.demo.model.OrderEntity;
import com.example.combi.demo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrdersConsumer {
    private final Logger logger = LoggerFactory.getLogger(OrdersConsumer.class);
    @Autowired
    OrderRepository orderRepository;
    @KafkaListener(topics = "orders",containerFactory="orderKafkaListenerContainerFactory")
    public void consume(String uuid, Order message) throws IOException {
        logger.info(String.format("#### -&gt; Consumed message -&gt; %s", message));


        Optional<OrderEntity> oe = orderRepository.findById(message.id);
        if (oe.isEmpty()) {
            OrderEntity record=oe.get();
            record.description= message.description;
            record.quantity = record.quantity;
            record.id= Math.toIntExact((Long) message.id);
            orderRepository.save(record);
            logger.info("message persisted successfully");
        }
    }
}
