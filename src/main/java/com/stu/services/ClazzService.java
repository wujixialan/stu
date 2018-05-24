package com.stu.services;

import com.stu.entity.Clazz;

import java.util.List;

public interface ClazzService {
    /**
     * 获取班级的总记录
     * @return
     */
    public List<Clazz> getAllClazz();

    /**
     * 获取班级的记录数
     * @return
     */
    public long getAllTotal();
}
