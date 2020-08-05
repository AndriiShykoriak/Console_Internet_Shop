package com.company.order.dao.impl;

import com.company.order.dao.OrderDao;
import com.company.order.model.Order;
import com.company.product.dao.impl.ProductDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends ProductDaoImpl implements OrderDao {
    int count = 0;
    private static Map<Integer, Order> orderMap = new HashMap<>();
    @Override
    public void createOrder(Order order) {
        count++;
        order.setId(count);
        orderMap.put(count, order);
    }

    @Override
    public void editOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    @Override
    public void deleteProduct(Order order) {
        orderMap.remove(order.getId());
    }

    @Override
    public List<Order> findAllOrder() {
        return new ArrayList<>(orderMap.values());
    }
}
