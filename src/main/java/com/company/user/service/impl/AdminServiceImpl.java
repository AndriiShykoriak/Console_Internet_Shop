package com.company.user.service.impl;

import com.company.user.dao.impl.UserDaoImpl;
import com.company.user.model.enums.Status;
import com.company.user.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private static UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void blockUser(String login) {
        userDao.userMap.values().stream()
                .filter(user -> user.getLogin().equals(login))
                .forEach(user -> user.setStatus(Status.BLOCKED));
    }

    @Override
    public void unblockUser(String login) {
        userDao.userMap.values().stream()
                .filter(user -> user.getLogin().equals(login))
                .forEach(user -> user.setStatus(Status.ACTIVE));
    }
}