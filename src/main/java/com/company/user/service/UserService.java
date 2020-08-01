package com.company.user.service;

import com.company.user.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findByLogin(String login);
    User findByPassword(String password);
    User findById(int id);
    List<User> findAllUsers();
}
