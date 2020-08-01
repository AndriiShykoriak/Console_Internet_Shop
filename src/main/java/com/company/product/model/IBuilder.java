package com.company.product.model;

import com.company.product.model.enums.Category;

public interface IBuilder {

    IBuilder setId(int id);

    IBuilder setName(String name);

    IBuilder setProductCode(Long productCode);

    IBuilder setCategory(Category category);

    IBuilder setProducer(String producer);

    IBuilder setPrice(Float price);

    <T> T build();
}
