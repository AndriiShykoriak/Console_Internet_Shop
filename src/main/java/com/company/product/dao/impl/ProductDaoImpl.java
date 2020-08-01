package com.company.product.dao.impl;

import com.company.product.dao.ProductDao;
import com.company.product.model.Product;
import com.company.product.model.enums.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    public static Map<Integer, Product> products = new HashMap<>();
    int productId = 9;

    static {

        products.put(1, new Product(1, "VHS", 123456L, Category.AUDIO_VIDEO, "Sony", 120.0f));
        products.put(2, new Product(2, "Ipnone", 53264L, Category.MOBILE, "Apple", 499.99f));
        products.put(3, new Product(3, "TV", 325655L, Category.TELEVISION, "Samsung", 800.00f));
        products.put(4, new Product(4, "PS4", 6454351L, Category.COMPUTER_PERIPHERAL, "Sony", 450.0f));
        products.put(5, new Product(5, "XBOX", 542155313L, Category.COMPUTER_PERIPHERAL, "Microsoft", 500.0f));
        products.put(6, new Product(6, "S9+", 54864L, Category.MOBILE, "Samsung", 800.0f));
        products.put(7, new Product(7, "Mate Pad Pro", 3215668L, Category.TABLETS, "Huawei", 320.0f));
        products.put(8, new Product(8, "JBL Charje 4", 351545L, Category.AUDIO_VIDEO, "JBL", 50.0f));
        products.put(9, new Product(9, "Mi Smart Band 5 ", 165651L, Category.COMPUTER_PERIPHERAL, "Xiaomi", 30.0f));
    }

    @Override
    public void addProduct(Product product) {
        productId++;
        product.setId(productId);
        products.put(productId, product);

    }

    @Override
    public void editProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findByAllProduct() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product.getId());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    public void printByCategory(Category category1) {
        products.values().
                stream()
                .filter(category -> category.getCategory().equals(category1))
                .forEach(x -> System.out.println(x));
    }
}
