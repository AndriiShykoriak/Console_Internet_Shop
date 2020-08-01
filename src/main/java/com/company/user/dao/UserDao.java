package com.company.user.dao;

import com.company.user.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findByLogin(String login);
    User findByPassword(String password);
    User findById(int id);
    List<User> findAllUsers();
}
