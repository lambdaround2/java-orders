package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Order;

import java.util.List;

public interface OrderService
{
    List<Order> findAll();

    Order findById(long id);

    Order save(Order order);

    Order update(Order order, long id);

    void delete(long id);
}
