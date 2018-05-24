package com.stu.util;

import java.util.Map;

public class PagMap {
    public static Map<Object, Object> map(Map<Object, Object> map, Object key, Object value) {
        map.put(key, value);
        return map;
    }
}
