package com.company.user.dao.impl;

import com.company.user.dao.UserDao;
import com.company.user.model.User;
import com.company.user.model.enums.Rights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private int count = 1;
    public static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1, new User(1, "admin", "admin", Rights.ADMIN));
    }

    public void create(User user) {
        count++;
        user.setId(count);
        userMap.put(count, user);
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(User user) {
        userMap.remove(user.getId());
    }

    public User findByLogin(String login) {
        return userMap.values().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByPassword(String password) {
        return userMap.values().stream()
                .filter(user -> user.getLogin().equals(password))
                .findFirst()
                .orElse(null);
    }

    public User findById(int id) {
        return userMap.get(id);
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(userMap.values());
    }

}
