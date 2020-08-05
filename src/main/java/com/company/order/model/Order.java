package com.company.order.model;

import com.company.product.model.Product;
import com.company.user.model.User;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int id;
    private User user;
    private List<Product> product;
    public Order( User user, List<Product> values) {
        this.user = user;
        this.product = values;
    }

}
