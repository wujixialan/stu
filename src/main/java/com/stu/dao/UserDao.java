package com.stu.dao;

import com.stu.entity.User;

import java.util.List;

public interface UserDao {
    public User getUser(User user);

    public User findUserByUserId(User user);

    public void save(User user);

    public void changePassword(User user);

    public List<User> authorized(User user);

    public long authorizedTotal(User user);

    public void importUser(List<User> users);
}
