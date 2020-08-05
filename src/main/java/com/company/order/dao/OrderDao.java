package com.company.order.dao;

import com.company.order.model.Order;

import java.util.List;

public interface OrderDao {
    void createOrder(Order order);

    void editOrder(Order order);

    void deleteProduct(Order order);

    List<Order> findAllOrder();
}
