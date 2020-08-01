package com.company.product.service.impl;

import com.company.product.dao.ProductDao;
import com.company.product.dao.impl.ProductDaoImpl;
import com.company.product.model.Product;
import com.company.product.model.enums.Category;
import com.company.product.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    @Override
    public List<Product> findByAllProduct() {
        return productDao.findByAllProduct();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void printByCategory(Category category) {
        productDao.printByCategory(category);
    }

}
