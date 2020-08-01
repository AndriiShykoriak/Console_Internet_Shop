package com.company.product.view.impl;

import com.company.product.model.Product;
import com.company.product.model.enums.Category;
import com.company.product.model.impl.ProductBuilder;
import com.company.product.service.ProductService;
import com.company.product.service.impl.ProductServiceImpl;
import com.company.product.view.ProductView;

import static com.company.config.Scanner.ReadString;

public class ProductViewImpl implements ProductView {
    ProductService productService = new ProductServiceImpl();

    @Override
    public void addProduct() {
        ProductBuilder productBuilder = new ProductBuilder();
        Product product;
        product = productBuilder
                .setName(productBuilderName())
                .setProductCode(productBuilderProductCode())
                .setProducer(productBuilderProducer())
                .setPrice(productBuilderPrice())
                .setCategory(category())
                .build();
        productService.addProduct(product);
        System.out.println("Added product");
    }

    @Override
    public void editProduct() {
        System.out.println("Enter id: ");
        Product product = productService.findById(Integer.parseInt(ReadString()));
        ProductBuilder productBuilder = new ProductBuilder();
        if (product != null) {
            productBuilder
                    .setName(productBuilderName())
                    .setProductCode(productBuilderProductCode())
                    .setProducer(productBuilderProducer())
                    .setPrice(productBuilderPrice())
                    .setCategory(category())
                    .build();
        }
        productService.editProduct(product);
        System.out.println("Edited Product");
    }

    @Override
    public void deleteProduct() {
        System.out.println("Enter id:");
        Product product = productService.findById(Integer.parseInt(ReadString()));
        if (product != null) {
            productService.deleteProduct(product);
            System.out.println("Deleted");
        } else {
            System.out.println("User does not exist");
        }
    }

    @Override
    public void findByAllProduct() {
        productService.findByAllProduct().forEach(System.out::println);
    }

    private String productBuilderName() {
        System.out.println("Input name: ");
        String name = ReadString();
        return name;
    }

    private Long productBuilderProductCode() {
        System.out.println("Input productCode: ");
        long productCode = Long.parseLong(ReadString());
        return productCode;
    }

    private String productBuilderProducer() {
        System.out.println("Input producer: ");
        String producer = ReadString();
        return producer;
    }

    private Float productBuilderPrice() {
        System.out.println("Input price: ");
        Float price = Float.valueOf(ReadString());
        return price;
    }

    private Category category() {
        System.out.println("\t\t\t\t\tALL CATEGORIES");
        System.out.println("1.COMPUTER_PERIPHERAL 2.AUDIO_VIDEO 3.MOBILE 4.TABLETS 5.TELEVISION " +
                "6.CAMERA 7.GAMING 8.LAPTOPS 9.MOBILE_ACCESSORY 10.TABLET_ACCESSORY");
        String count = ReadString();
        Category category = switch (count) {
            case "1" -> Category.COMPUTER_PERIPHERAL;
            case "2" -> Category.AUDIO_VIDEO;
            case "3" -> Category.MOBILE;
            case "4" -> Category.TABLETS;
            case "5" -> Category.TELEVISION;
            case "6" -> Category.CAMERA;
            case "7" -> Category.GAMING;
            case "8" -> Category.LAPTOPS;
            case "9" -> Category.MOBILE_ACCESSORY;
            case "10" -> Category.TABLET_ACCESSORY;
            default -> Category.OTHER;
        };
        return category;
    }
}