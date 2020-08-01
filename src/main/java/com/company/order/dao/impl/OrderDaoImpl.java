package com.company.order.dao.impl;

import com.company.order.dao.OrderDao;
import com.company.order.model.Order;
import com.company.product.model.Product;
import com.company.user.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {
    int count = 0;
    static private List<Order> listOrder = new ArrayList<>();
    static private Map<User,List<Product>> userProductMap = new HashMap<>();

    static {
        listOrder.add((Order) userProductMap);
    }
    private Map<Integer, List<Order>> orderMap = new HashMap<>();

    @Override
    public void createOrder(Order order) {
        count++;
        order.setId(count);
        orderMap.put(count, (List<Order>) order);
    }

    @Override
    public void editOrder(Order order) {
        orderMap.put(order.getId(), (List<Order>) order);
    }

    @Override
    public void deleteProduct(Order order) {
        orderMap.remove(order.getId());
    }

    @Override
    public List<Order> findAllOrder() {
        return new ArrayList(orderMap.values());
    }

    @Override
    public HashMap<User, List<Product>> findById(int id) {
        return (HashMap<User, List<Product>>) orderMap.get(id);
    }
}
