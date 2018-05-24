package com.stu.services.impl;

import com.stu.dao.ClazzDao;
import com.stu.entity.Clazz;
import com.stu.services.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<Clazz> getAllClazz() {
        return clazzDao.getAllClazz();
    }

    @Override
    public long getAllTotal() {
        return clazzDao.getAllTotal();
    }
}
