package com.stu.dao;

import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao {
    public Session getSession();
}
