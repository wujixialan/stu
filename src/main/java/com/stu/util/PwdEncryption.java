package com.stu.util;

import com.stu.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by zxg on 2018/5/6.
 */
public class PwdEncryption {
    public static User encryption(User user) {
        String result = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(result);
        return user;
    }
}
