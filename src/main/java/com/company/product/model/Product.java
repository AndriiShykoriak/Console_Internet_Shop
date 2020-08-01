package com.company.product.model;

import com.company.product.model.enums.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private int id;
    private String name;
    private Long productСode;
    private Category category;
    private String producer;
    private Float price;

    public Product(String name, Long productСode, Category category, String producer, Float price) {
        this.name = name;
        this.productСode = productСode;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }
}
