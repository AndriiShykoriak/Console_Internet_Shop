package com.company.view.impl;

import com.company.product.view.impl.MenuProductImpl;
import com.company.user.view.impl.MenuAdminImpl;
import com.company.view.MainMenuAdmin;

import static com.company.config.Scanner.ReadString;

public class MainMenuAdminImpl implements MainMenuAdmin {
    private final String[] adminMenuItems = {
            "1. Block/unblock user Edit/Delete/FindAll user",
            "2. Product Menu",
            "0. AuthorizationMenu"
    };

    @Override
    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    @Override
    public void runMenuMainAdmin() {
        System.out.println("\t\t\tADMIN MENU");
        showMenuItems(adminMenuItems);
        loop:
        while (true) {
            switch (ReadString()) {
                case "1" -> {
                    runSubMenuAdmin();
                    System.out.println("0.Back");
                }
                case "2" -> {
                    runSubMenuProductAdmin();
                    System.out.println("0.Back");
                }
                case "0" -> {
                    break loop;
                }
                default -> {
                    System.out.println("Wrong input, try one more time");
                    runMenuMainAdmin();
                }
            }
        }
    }
    @Override
    public void runSubMenuAdmin() {
        new MenuAdminImpl().MenuAdmin();
        runMenuMainAdmin();
    }

    @Override
    public void runSubMenuProductAdmin() {
        new MenuProductImpl().MenuProduct();
        runMenuMainAdmin();
    }
}
