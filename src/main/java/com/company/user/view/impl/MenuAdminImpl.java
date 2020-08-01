package com.company.user.view.impl;

import com.company.user.service.AdminService;
import com.company.user.service.impl.AdminServiceImpl;
import com.company.user.view.MenuAdmin;

import static com.company.config.Scanner.ReadString;

public class MenuAdminImpl implements MenuAdmin {
    AdminService adminService = new AdminServiceImpl();
    private final String[] subMenuUserBlockItems = {
            "1. Block user",
            "2. Unblock user",
            "3. Edit user",
            "4. Delete user",
            "5  FindAllUsers",
            "6. Back",
            "0. Exit"
    };
    public void MenuAdmin() {

        showMenuItems(subMenuUserBlockItems);
        loop:
        while (true) {
            switch (ReadString()) {

                case "1" -> {
                    System.out.println("Enter user login for block");   //Better would be if block user was by ID
                    String login = ReadString();
                    adminService.blockUser(login);
                    System.out.println("User " + login + " was blocked");
                    MenuAdmin();
                }
                case "2" -> {
                    System.out.println("Enter user login for unblock");
                    String login = ReadString();
                    adminService.unblockUser(login);
                    System.out.println("User " + login + " was unblocked");
                    MenuAdmin();
                }
                case "3" -> new UserViewImpl().updateUser();
                case "4" -> new UserViewImpl().deleteUser();
                case "5" -> new UserViewImpl().findAllUser();
                case "6" -> MenuAdmin();
                case "0" -> {
                    break loop;
                }
                default -> {
                    System.out.println("Wrong input, try one more time");
                }
            }
        }
    }

    @Override
    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }
}