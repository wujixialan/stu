package com.stu.dao;

import com.stu.entity.Clazz;

import java.util.List;

public interface ClazzDao {
    public List<Clazz> getAllClazz();

    public long getAllTotal();
}
