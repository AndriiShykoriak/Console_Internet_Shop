package com.company.product.view.impl;

import com.company.product.view.MenuProduct;

import static com.company.config.Scanner.ReadString;

public class MenuProductImpl implements MenuProduct {
    private final String[] subMenuProductItems = {
            "1. Show all products",
            "2. Add product",
            "3. Edit product",
            "4. Delete product",
            "5. Back",
            "0. UserMenu"
    };

    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    public void MenuProduct() {
        showMenuItems(subMenuProductItems);
        loop:
        while (true) {
            switch (ReadString()) {
                case "1" -> {
                    new ProductViewImpl().findByAllProduct();
                    System.out.println("5.Back 0. User Menu");
                }
                case "2" -> {
                    new ProductViewImpl().addProduct();
                    System.out.println("5.Back 0. User Menu");
                }
                case "3" -> {
                    new ProductViewImpl().editProduct();
                    System.out.println("5.Back 0. User Menu");
                }
                case "4" -> {
                    new ProductViewImpl().deleteProduct();
                    System.out.println("5.Back 0. User Menu");
                }
                case "5" -> MenuProduct();
                case "0" -> {
                    break loop;
                }

                default -> {
                    System.out.println("Wrong input, try one more time");
                   break loop;
                }
            }
        }
    }
}