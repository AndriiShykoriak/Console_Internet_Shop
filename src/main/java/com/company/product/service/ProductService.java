package com.company.product.service;

import com.company.product.model.Product;
import com.company.product.model.enums.Category;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> findByAllProduct();

    Product findById(int id);

    void  printByCategory(Category category);
}
