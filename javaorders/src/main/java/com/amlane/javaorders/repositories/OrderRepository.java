package com.amlane.javaorders.repositories;

import com.amlane.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
}
