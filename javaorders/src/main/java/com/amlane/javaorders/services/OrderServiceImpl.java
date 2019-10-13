package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Order;
import com.amlane.javaorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository ordrepos;

    @Override
    public List<Order> findAll()
    {
        List<Order> list = new ArrayList<>();
        ordrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Order findById(long id) throws EntityNotFoundException
    {
        return ordrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Order save(Order order)
    {
        return null;
    }

    @Override
    public Order update(Order order, long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }
}
