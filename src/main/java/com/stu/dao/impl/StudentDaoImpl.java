package com.stu.dao.impl;

import com.stu.dao.StudentDao;
import com.stu.entity.Student;
import com.stu.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {
    /**
     * 获取所有的学生信息
     *
     * @return
     */
    @Override
    public List<Student> getAllStudent() {
        String hql = "from Student";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    /**
     * 获取学生的所有记录
     *
     * @return
     */
    @Override
    public long getStudentTotal(Student student, User user) {
        Criteria criteria = getSession().createCriteria(Student.class);
        if (user != null && user.getUserType().equals("学生")) {
            criteria.add(Restrictions.eq("sid", user.getUserId()));
        }
        if (student.getName() != null) {
            criteria.add(Restrictions.or(Restrictions.like("name", student.getName(), MatchMode.ANYWHERE)));
        }
        if (student.getIdCard() != null) {
            criteria.add(Restrictions.or(Restrictions.like("idCard", student.getIdCard(), MatchMode.ANYWHERE)));
        }
        if (!student.getClazz().getCid().equals("请选择")) {
            criteria.add(Restrictions.or(Restrictions.eq("clazz.cid", student.getClazz().getCid())));
        }
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    /**
     * 根据 sid 查询一个学生的信息。
     *
     * @param sid ：需要查询的学生 id
     * @return：需要返回一个学生的对象。
     */
    @Override
    public Student findStudent(String sid) {
        String hql = "from Student s where s.sid = :sid";
        return (Student) getSession().createQuery(hql)
                .setString("sid", sid)
                .uniqueResult();
    }

    /**
     * 添加学生的基本信息
     *
     * @param student : 要添加的 Student 对象。
     */
    @Override
    public void stuAdd(Student student) {
        getSession().saveOrUpdate(student);
    }

    /**
     * 获取所有的学生信息
     *
     * @param page
     * @param limit
     * @param student
     * @param user
     * @return
     */
    @Override
    public List<Student> getAllPageStudent(int page, int limit, Student student, User user) {
        Criteria criteria = getSession().createCriteria(Student.class);
        if (user != null && user.getUserType().equals("学生")) {
            criteria.add(Restrictions.eq("sid", user.getUserId()));
        }
        if (student.getName() != null) {
            criteria.add(Restrictions.or(Restrictions.like("name", student.getName(), MatchMode.ANYWHERE)));
        }
        if (student.getIdCard() != null) {
            criteria.add(Restrictions.or(Restrictions.like("idCard", student.getIdCard(), MatchMode.ANYWHERE)));
        }
        if (!student.getClazz().getCid().equals("请选择")) {
            criteria.add(Restrictions.or(Restrictions.eq("clazz.cid", student.getClazz().getCid())));
        }
        return criteria.setFirstResult(limit * (page - 1))
                .setMaxResults(limit).list();
    }

    /**
     * 通过学生姓名查询 id；
     *
     * @param student
     * @return
     */
    @Override
    public Student findByName(Student student) {
        String hql = "from Student s where s.name = :name";
        return (Student) getSession().createQuery(hql)
                .setString("name", student.getName())
                .uniqueResult();
    }

    /**
     * 删除学生信息
     *
     * @param stu
     */
    @Override
    public void delStu(Student stu) {
        getSession().delete(stu);
    }
}
