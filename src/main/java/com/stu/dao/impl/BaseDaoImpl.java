package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDaoImpl implements BaseDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
