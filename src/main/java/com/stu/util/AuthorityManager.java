package com.stu.util;

import com.stu.entity.User;

import javax.servlet.http.HttpServletRequest;

public class AuthorityManager {
    /**
     * 判断 Session 中是否存在用户，如果不存在返回 false，否则返回 true。
     * @param request
     * @return
     */
    public static boolean isUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}
