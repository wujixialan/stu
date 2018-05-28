package com.stu.util;

import cn.hutool.core.util.RandomUtil;

/**
 * Created by zxg on 2018/5/7.
 * 生成 UUID 的工具类。
 */
public class UUIDUtils {
    /**
     * 生成 UUID。
     * @return
     */
    public static String uuid() {
//        return UUID.randomUUID().toString().replace("-", "");
        return RandomUtil.simpleUUID();
    }
}
