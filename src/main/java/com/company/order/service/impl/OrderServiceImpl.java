package com.company.order.service.impl;

import com.company.order.dao.OrderDao;
import com.company.order.dao.impl.OrderDaoImpl;
import com.company.order.model.Order;
import com.company.product.model.Product;
import com.company.user.model.User;

import java.util.HashMap;
import java.util.List;

public class OrderServiceImpl implements OrderDao {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void createOrder(Order order) {
    orderDao.createOrder(order);
    }

    @Override
    public void editOrder(Order order) {
    orderDao.editOrder(order);
    }

    @Override
    public void deleteProduct(Order order) {
    orderDao.deleteProduct(order);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public HashMap<User, List<Product>> findById(int id) {
        return orderDao.findById(id);
    }
}