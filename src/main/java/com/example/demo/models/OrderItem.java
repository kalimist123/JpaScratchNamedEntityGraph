package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private int quantity;

    @ManyToOne
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;



}