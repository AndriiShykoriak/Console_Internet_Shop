package com.company.order.view.impl;

import com.company.order.model.Order;
import com.company.order.service.OrderService;
import com.company.order.service.impl.OrderServiceImpl;
import com.company.order.view.OrderView;
import com.company.product.model.Product;
import com.company.product.service.ProductService;
import com.company.product.service.impl.ProductServiceImpl;
import com.company.user.model.User;
import com.company.view.impl.AuthorizationMenuImpl;

import java.util.Collections;
import java.util.List;

import static com.company.config.Scanner.ReadString;

public class OrderViewImpl implements OrderView {
    OrderService orderService = new OrderServiceImpl();

    private ProductService productService = new ProductServiceImpl();
    @Override
    public void addOrder() {
        System.out.println("Confirm login: ");
        User userOrder = new AuthorizationMenuImpl().currentUser();
        System.out.println("Add productId: ");
        List<Product> productOrder = Collections.singletonList(productService.findById(Integer.parseInt(ReadString())));
        Order order = new Order(userOrder, productOrder);
        System.out.println("order saved");
        orderService.createOrder(order);
    }

    @Override
    public void ShowOrder() {
        orderService.findAllOrder().forEach(x->System.out.println(x));
    }
}
