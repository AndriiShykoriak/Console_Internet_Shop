package com.company.view.impl;

import com.company.order.service.OrderService;
import com.company.order.service.impl.OrderServiceImpl;
import com.company.product.model.enums.Category;
import com.company.product.service.ProductService;
import com.company.product.service.impl.ProductServiceImpl;
import com.company.product.view.impl.MenuProductImpl;
import com.company.view.MainMenuUser;

import static com.company.config.Scanner.ReadString;

public class MainMenuUserImpl implements MainMenuUser {
    ProductService productService = new ProductServiceImpl();
//    OrderService orderService = (OrderService) new OrderServiceImpl();
    private final String[] menu = {
            "1. Show available products.",
            "2. Search categories.",
            "3. Add items to order.",
            "4. Show my order.",
            "4. Check-out.",
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
                case "2" -> runSubMenuUser();
//                case "3" -> addOrder();
//                case "4" -> ShowOrder();
                case "5" -> Payment();
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
                "1. Mobile\n" +
                        "    2. Tablets\n" +
                        "    3. Computer peripherals\n" +
                        "    4. Audio & Video\n" +
                        "    5. Television\n" +
                        "    6. LAPTOPS\n" +
                        "    7. MOBILE_ACCESSORY\n" +
                        "    8. TABLET_ACCESSORY\n" +
                        "    9. CAMERA\n" +
                        "    10. GAMING\n" +
                        "    11. OTHER\n");

        int dec = Integer.parseInt(ReadString());

        if (dec == 1) {
            productService.printByCategory(Category.MOBILE);
        } else if (dec == 2) {
            productService.printByCategory(Category.TABLETS);
        } else if (dec == 3) {
            productService.printByCategory(Category.COMPUTER_PERIPHERAL);
        } else if (dec == 4) {
            productService.printByCategory(Category.AUDIO_VIDEO);
        } else if (dec == 5) {
            productService.printByCategory(Category.TELEVISION);
        } else if (dec == 6) {
            productService.printByCategory(Category.LAPTOPS);
        } else if (dec == 7) {
            productService.printByCategory(Category.MOBILE_ACCESSORY);
        } else if (dec == 8) {
            productService.printByCategory(Category.TABLET_ACCESSORY);
        } else if (dec == 9) {
            productService.printByCategory(Category.CAMERA);
        } else if (dec == 10) {
            productService.printByCategory(Category.GAMING);
        } else if (dec == 11) {
            productService.printByCategory(Category.OTHER);
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

//    @Override
//    public void addOrder() {
//        Order order = new Order();
//        orderService.createOrder(order);
//    }
//
//    @Override
//    public void ShowOrder() {
//        orderService.findAllOrder().forEach(x->System.out.println(x));
//    }
}
