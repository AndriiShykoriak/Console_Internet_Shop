package com.company.user.view.impl;

import com.company.user.model.User;
import com.company.user.service.UserService;
import com.company.user.service.impl.UserServiceImpl;
import com.company.user.view.UserView;

import static com.company.config.Scanner.ReadString;

public class UserViewImpl implements UserView {
    private UserService userService = new UserServiceImpl();

    @Override
    public void addUser() {
        System.out.println("Registration");
        User user = new User();
        System.out.print("Input Login:    ");
        user.setLogin(ReadString());
        System.out.print("Input password: ");
        user.setPassword(ReadString());
        System.out.print("Input name:     ");
        user.setName(ReadString());
        System.out.print("Input seName:   ");
        user.setSeName(ReadString());
        userService.create(user);
        System.out.println("Saved, go to login");
    }

    @Override
    public void updateUser() {
        System.out.println("Enter id:");
        User user = userService.findById(Integer.parseInt(ReadString()));
        if (user != null) {
            System.out.print("Update login: " + user.getLogin());
            user.setLogin(ReadString());
            System.out.print("Update password: " + user.getPassword());
            user.setPassword(ReadString());
            System.out.println("Update name: " + user.getName());
            user.setName(ReadString());
            System.out.println("Update seName: " + user.getSeName());
            user.setSeName(ReadString());
            userService.update(user);
            System.out.println("User " + user.getLogin() + user.getPassword() + user.getName() + user.getSeName() + " updated");
        } else {
            System.out.println("User does not exist");
        }
    }

    @Override
    public void deleteUser() {
        System.out.println("Enter id:");
        User user = userService.findById(Integer.parseInt(ReadString()));
        if (user != null) {
            userService.delete(user);
            System.out.println("Deleted");
        } else {
            System.out.println("User does not exist");
        }
    }
    @Override
    public void findAllUser(){
        userService.findAllUsers().forEach(System.out::println);
    }
}
