package com.company.view.impl;

import com.company.user.model.User;
import com.company.user.model.enums.Rights;
import com.company.user.service.UserService;
import com.company.user.service.impl.UserServiceImpl;
import com.company.user.view.impl.UserViewImpl;
import com.company.view.AuthorizationMenu;
import lombok.SneakyThrows;

import static com.company.config.Scanner.ReadString;

public class AuthorizationMenuImpl implements AuthorizationMenu {
    private UserService userService = new UserServiceImpl();

    @SneakyThrows
    public void authorization() {
        int count;
        loop:
        while (true) {
            System.out.println("1-Registration 2-Login 3-Exit");
            count = Integer.parseInt(ReadString());
            switch (count) {
                case 1 -> new UserViewImpl().addUser();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exit");
                    break loop;
                }
            }
        }
    }

    @Override
    public void login() {
        System.out.print("Enter login: ");
        if (currentUser().getRights().equals(Rights.ADMIN)) {
            password();
            new MainMenuAdminImpl().runMenuMainAdmin();
        } else {
            password();
            new MainMenuUserImpl().runMenuMainUser();
        }
    }

    @Override
    public void password() {
        System.out.print("Password:    ");
        User user = userService.findByPassword(ReadString());
        if (user.getPassword() != null) {
            System.out.println("login:" + user);
        } else {
            System.out.println("password error");
        }
    }
    public User currentUser(){
        User currentUser = userService.findByLogin(ReadString());
        return currentUser;
    }
}
