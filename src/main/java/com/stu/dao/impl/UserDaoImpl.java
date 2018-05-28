package com.stu.dao.impl;

import com.stu.dao.UserDao;
import com.stu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User getUser(User user) {
        String hql = "from User u where u.userId = :userId and u.password = :password and u.userType = :userType";
        return (User) getSession().createQuery(hql)
                .setString("userId", user.getUserId())
                .setString("password", user.getPassword())
                .setString("userType", user.getUserType())
                .uniqueResult();
    }

    @Override
    public User findUserByUserId(User user) {
        String hql = "from User u where u.userId = :userId";
        User user1 = (User) getSession().createQuery(hql)
                .setString("userId", user.getUserId())
                .uniqueResult();
        return user1;
    }

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public void changePassword(User user) {
        String hql = "update User u set u.password = :password where u.userId = :userId";
        getSession().createQuery(hql).setString("password", user.getPassword())
                .setString("userId", user.getUserId()).executeUpdate();
    }

    @Override
    public List<User> authorized(User user) {
        String hql = "from User u where u.userId <> :userId and u.userType <> :userType";
        return getSession().createQuery(hql)
                .setString("userId", user.getUserId())
                .setString("userType", user.getUserType())
                .list();
    }

    @Override
    public long authorizedTotal(User user) {
        /**
         * hql 查询中 不等于 用 <> 表示
         */
        String hql = "select count(userId) from User u where u.userId <> :userId and u.userType <> :userType";
        return (long) getSession().createQuery(hql)
                .setString("userId", user.getUserId())
                .setString("userType", user.getUserType())
                .uniqueResult();
    }
}