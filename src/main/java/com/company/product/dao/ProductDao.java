package com.company.product.dao;

import com.company.product.model.Product;
import com.company.product.model.enums.Category;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    void editProduct(Product product);

    List<Product> findByAllProduct();

    void deleteProduct(Product product);

    Product findById(int id);

    void printByCategory(Category category);
}
