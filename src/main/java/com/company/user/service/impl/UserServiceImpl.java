package com.company.user.service.impl;

import com.company.user.dao.UserDao;
import com.company.user.dao.impl.UserDaoImpl;
import com.company.user.model.User;
import com.company.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User findByPassword(String password) {
        return userDao.findByPassword(password);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
