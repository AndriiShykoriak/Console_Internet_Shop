package com.company.product.model.impl;

import com.company.product.model.IBuilder;
import com.company.product.model.Product;
import com.company.product.model.enums.Category;

public class ProductBuilder implements IBuilder {
    private int id;
    private String name;
    private Long productСode;
    private Category category;
    private String producer;
    private Float price;

    public int getId() {
        return id;
    }

    @Override
    public IBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public IBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IBuilder setProductCode(Long productCode) {
        this.productСode = productCode;
        return this;
    }

    @Override
    public IBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public IBuilder setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Override
    public IBuilder setPrice(Float price) {
        this.price = price;
        return this;
    }

    @Override
    public Product build() {
        return new Product(name, productСode, category, producer, price);
    }
}