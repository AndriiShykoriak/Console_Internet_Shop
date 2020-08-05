package com.company.order.service;

import com.company.order.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    void editOrder(Order order);
    void deleteProduct(Order order);
    List<Order> findAllOrder();
}
