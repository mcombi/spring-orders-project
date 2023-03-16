package com.example.combi.demo.repository;
import java.util.List;
import java.util.Optional;

import com.example.combi.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    Optional<Order> findById(Long Id);
}
