package com.example.combi.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderentity")
public class OrderEntity {
    public String description;
    @Id
    public int id;
    public int quantity;

}
