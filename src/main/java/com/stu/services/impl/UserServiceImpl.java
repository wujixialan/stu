package com.stu.services.impl;

import com.stu.dao.UserDao;
import com.stu.entity.User;
import com.stu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录的时候，查找用户的方法
     *
     * @param user ：传入的 User 对象。
     * @return
     */
    @Override
    public boolean getUser(User user) {
        User findUser = userDao.getUser(user);
        /**
         * 当 findUser 为 null 时，返回 false，否则，返回 true。
         */
        if (findUser != null) {
            return true;
        }
        return false;
    }

    /**
     * 通过 userId 获取用户。
     *
     * @param user ：传入的对象。
     * @return：如果为 null，返回 true，说明该用户存在，不能注册，若不为 null，返回 false，说明该用户不存在，可以注册。
     */
    @Override
    public boolean findUserByUserId(User user) {
        User findUser = userDao.findUserByUserId(user);
        if (findUser == null) {
            return true;
        }
        return false;
    }

    /**
     * 实现注册用户的功能
     *
     * @param user
     */
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    /**
     * 通过 session 中的用户，获取密码。
     *
     * @param user ：传入的用户
     * @return
     */
    @Override
    public boolean getOldPwd(User user) {
        User findUser = userDao.findUserByUserId(user);
        if (findUser.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    /**
     * 修改密码
     *
     * @param user
     */
    @Override
    public void changePassword(User user) {
        userDao.changePassword(user);
    }

    /**
     * 查询非当前登录的用户和非管理员
     *
     * @param user ：当前用户
     * @return
     */
    @Override
    public List<User> authorized(User user) {
        return userDao.authorized(user);
    }

    /**
     * 可以授权的用户的总数。
     *
     * @param user
     * @return
     */
    @Override
    public long authorizedTotal(User user) {
        return userDao.authorizedTotal(user);
    }

    /**
     * 导入用户的登录信息
     *
     * @param users
     */
    @Override
    public void importUser(List<User> users) {
        userDao.importUser(users);
    }
}
