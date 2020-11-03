package com.example.demo.repositories;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

    Order findById(long id);
}
