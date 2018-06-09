package com.stu.services;

import com.stu.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 登录的时候，查找用户的方法
     * @param user：传入的 User 对象。
     * @return
     */
    public boolean getUser(User user);

    /**
     * 通过 userId 获取用户。
     * @param user：传入的对象。
     * @return：如果为 null，返回 true，说明该用户存在，不能注册，若不为 null，返回 false，说明该用户不存在。
     */
    public boolean findUserByUserId(User user);

    /**
     * 实现注册用户的功能
     * @param user
     */
    public void save(User user);

    /**
     * 通过 session 中的用户，获取密码。
     * @param user：传入的用户
     * @return
     */
    public boolean getOldPwd(User user);

    /**
     * 修改密码
     * @param user
     */
    public void changePassword(User user);

    /**
     * 查询非当前登录的用户和非管理员
     * @param user：当前用户
     * @return
     */
    public List<User> authorized(User user);

    /**
     * 可以授权的用户的总数。
     * @param user
     * @return
     */
    public long authorizedTotal(User user);

    /**
     * 导入用户的登录信息
     * @param users
     */
    public void importUser(List<User> users);
}
