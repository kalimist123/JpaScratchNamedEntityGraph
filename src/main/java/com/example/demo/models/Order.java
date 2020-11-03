package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchaseOrder")
@NamedEntityGraph(name = "graph.Order.items",
        attributeNodes = @NamedAttributeNode("items"))
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private String orderNumber;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<OrderItem>();

}