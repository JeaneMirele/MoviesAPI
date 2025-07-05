package com.movies.api.services;

import com.movies.api.domain.Order;
import com.movies.api.repositorys.OrderRepository;
import com.movies.api.services.generic.AbstractService;

public class OrderService extends AbstractService<Order, Long, OrderRepository> {
    public OrderService(OrderRepository repository){
        super(repository);
    }
}
