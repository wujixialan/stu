package com.stu.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 该工具类用来返回 Controller 层传递给前端的信息。
 */
public class Message {
    /**
     * code: 代表成功或失败的状态码
     */
    private int code;
    private static Map<Object, Object> map = new HashMap<>();

    public Message success() {
        this.map.put("code", 200);
        return this;
    }

    public Message fail() {
        this.map.put("code", 400);
        return this;
    }

    public Message add(Object key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
