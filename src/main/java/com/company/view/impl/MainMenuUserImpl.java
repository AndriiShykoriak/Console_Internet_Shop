package com.company.view.impl;

import com.company.order.view.impl.OrderViewImpl;
import com.company.product.model.enums.Category;
import com.company.product.service.ProductService;
import com.company.product.service.impl.ProductServiceImpl;
import com.company.product.view.impl.MenuProductImpl;
import com.company.view.MainMenuUser;

import static com.company.config.Scanner.ReadString;

public class MainMenuUserImpl implements MainMenuUser {
    ProductService productService = new ProductServiceImpl();
    private final String[] menu = {
            "1. Show available products.",
            "2. Search categories.",
            "3. Add items to order.",
            "4. Show my order.",
            "5. Check-out.",
            "0. Back.",
            "15. AuthorizationMenu",
    };

    @Override
    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    @Override
    public void runMenuMainUser() {
        System.out.println("\t\t\tUser MENU");
        showMenuItems(menu);
        loop:
        while (true) {
            switch (ReadString()) {
                case "1" -> runSubMenuProductUser();
                case "2" -> {
                    runSubMenuUser();
                    runMenuMainUser();
                }
                case "3" -> {
                    new OrderViewImpl().addOrder();
                    runMenuMainUser();
                }
                case "4" -> {
                    new OrderViewImpl().ShowOrder();
                    runMenuMainUser();
                }
                case "5" -> {
                    Payment();
                    runMenuMainUser();
                }
                case "0" -> runMenuMainUser();
                case "15" -> {
                    break loop;
                }
                default -> {
                    System.out.println("Wrong input, try one more time");
                    runMenuMainUser();
                }
            }
        }
    }

    @Override
    public void runSubMenuUser() {
        checkCategories();
    }

    @Override
    public void runSubMenuProductUser() {
        new MenuProductImpl().MenuProduct();
        runMenuMainUser();
    }

    public void checkCategories() {
        System.out.println("Please chose the product category: ");
        System.out.println(
                        "    1. Mobile\n" +
                        "    2. Tablets\n" +
                        "    3. Computer peripherals\n" +
                        "    4. Audio & Video\n" +
                        "    5. Television\n" +
                        "    6. LAPTOPS\n" +
                        "    7. MOBILE_ACCESSORY\n" +
                        "    8. TABLET_ACCESSORY\n" +
                        "    9. CAMERA\n" +
                        "    10. GAMING\n" +
                        "    11. OTHER\n" +
                        "    0.  Back\n");

        int dec = Integer.parseInt(ReadString());
            switch (dec) {
                case 1 -> productService.printByCategory(Category.MOBILE);
                case 2 -> productService.printByCategory(Category.TABLETS);
                case 3 -> productService.printByCategory(Category.COMPUTER_PERIPHERAL);
                case 4 -> productService.printByCategory(Category.AUDIO_VIDEO);
                case 5 -> productService.printByCategory(Category.TELEVISION);
                case 6 -> productService.printByCategory(Category.LAPTOPS);
                case 7 -> productService.printByCategory(Category.MOBILE_ACCESSORY);
                case 8 -> productService.printByCategory(Category.TABLET_ACCESSORY);
                case 9 -> productService.printByCategory(Category.CAMERA);
                case 10 -> productService.printByCategory(Category.GAMING);
                case 11 -> productService.printByCategory(Category.OTHER);
            }
    }

    @Override
    public void Payment() {
        System.out.println("Do you want to pay with: \n" +
                "      1.Card\n" +
                "      2.Cash");
        int dec = Integer.parseInt(ReadString());
        if (dec == 1) {
            System.out.println("Thank you for transaction");
        } else {
            System.out.println("Sorry we don't currently accept cash, please use card");
        }
    }
}
