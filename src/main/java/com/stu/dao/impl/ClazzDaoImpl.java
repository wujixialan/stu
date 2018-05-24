package com.stu.dao.impl;

import com.stu.dao.ClazzDao;
import com.stu.entity.Clazz;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClazzDaoImpl extends BaseDaoImpl implements ClazzDao {
    @Override
    public List<Clazz> getAllClazz() {
        String hql = "from Clazz";
        return getSession().createQuery(hql).list();
    }

    @Override
    public long getAllTotal() {
        String hql = "select count(cid) from Clazz";
        return (long) getSession().createQuery(hql).uniqueResult();
    }
}
