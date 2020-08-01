package com.company.order.dao;

import com.company.order.model.Order;
import com.company.product.model.Product;
import com.company.user.model.User;

import java.util.HashMap;
import java.util.List;

public interface OrderDao {
    void createOrder(Order order);
    void editOrder(Order order);
    void deleteProduct(Order order);
    List<Order> findAllOrder();
    HashMap<User, List<Product>> findById(int id);
}
