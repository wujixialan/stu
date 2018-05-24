package com.stu.dao.impl;

import com.stu.analysis.MarkResult;
import com.stu.dao.MarkDao;
import com.stu.entity.Mark;
import com.stu.entity.Review;
import com.stu.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MarkDaoImpl extends BaseDaoImpl implements MarkDao {
    @Transactional
    @Override
    public void markAdd(Mark mark) {
        getSession().saveOrUpdate(mark);
    }

    @Override
    public List<Mark> findAllMark(User user, int page, int limit, Mark mark) {
        Criteria criteria = getSession().createCriteria(Mark.class);
        if (user != null && user.getUserType().equals("学生")) {
            criteria.add(Restrictions.eq("student.sid", user.getUserId()));
        }
        if (mark.getSubjectName() != null || !mark.getSubjectName().trim().equals("")) {
            criteria.add(Restrictions.like("subjectName", mark.getSubjectName(), MatchMode.ANYWHERE));
        }
        if (mark.getStudent().getSid() != null || !mark.getStudent().getSid().trim().equals("")) {
            criteria.add(Restrictions.like("student.sid", mark.getStudent().getSid(), MatchMode.ANYWHERE));
        }
        if (mark.getReview() != -1) {
            criteria.add(Restrictions.like("review", mark.getReview()));
        }
        return criteria.setFirstResult(limit * (page - 1))
                .setMaxResults(limit).list();
    }

    @Override
    public long getMarkTotal(User user, Mark mark) {
        Criteria criteria = getSession().createCriteria(Mark.class);
        if (user != null && user.getUserType().equals("学生")) {
            criteria.add(Restrictions.eq("student.sid", user.getUserId()));
        }
        if (mark.getSubjectName() != null || !mark.getSubjectName().trim().equals("")) {
            criteria.add(Restrictions.like("subjectName", mark.getSubjectName(), MatchMode.ANYWHERE));
        }
        if (mark.getStudent().getSid() != null || !mark.getStudent().getSid().trim().equals("")) {
            criteria.add(Restrictions.like("student.sid", mark.getStudent().getSid(), MatchMode.ANYWHERE));
        }
        if (mark.getReview() != -1) {
            criteria.add(Restrictions.like("review", mark.getReview()));
        }
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }

    @Override
    public Mark findMarkBySubjectId(String subjectId, String sid) {
        String hql = "from Mark m where m.markId = :markId and m.student.sid = :sid";
        return (Mark) getSession().createQuery(hql)
                .setString("markId", subjectId)
                .setString("sid", sid)
                .uniqueResult();
    }

    @Override
    public long getMarkTotalBySid(String sid) {
        String hql = "select count(*) from Mark m where m.student.sid = :sid";
        return (long) getSession().createQuery(hql).setString("sid", sid).uniqueResult();
    }

    @Override
    public List<Mark> getMarkBySid(String sid) {
        String hql = "from Mark m where m.student.sid = :sid";
        return getSession().createQuery(hql)
                .setString("sid", sid)
                .list();
    }

    @Override
    public Map<String, MarkResult> getMarkResult() {
        String sql = "select avg(score), sum(credit), avg(gpa), student.sid, student.name, clazz.clazzName from mark join student join clazz where mark.stu_id = student.sid and student.clazzId = clazz.cid group by mark.stu_id order by avg(score) desc";
        List list = getSession().createSQLQuery(sql).list();
        Map<String, MarkResult> markResults = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        list.stream().forEach(ele -> {
            MarkResult markResult = new MarkResult();
            Object[] objects = (Object[]) ele;
            markResult.setAvgScore((Double) objects[0]);
            markResult.setSumCredit((Double) objects[1]);
            markResult.setSumGpa((Double) objects[2]);
            markResult.setStuNo((String) objects[3]);
            markResult.setStuName((String) objects[4]);
            markResult.setClazzName((String) objects[5]);
            markResult.setIndex(index.get());
            markResults.put(markResult.getStuNo(), markResult);
            index.getAndIncrement();
        });
        return markResults;
    }

    @Transactional
    @Override
    public void delMarks(List<Mark> marks) {
        marks.stream().forEach(mark -> {
            getSession().delete(mark);
        });
    }

    @Transactional
    @Override
    public void delMark(Mark mark) {
        getSession().delete(mark);
    }

    @Override
    public void review(Review review) {
        getSession().save(review);
    }

    @Override
    public void updateReview(Mark mark) {
        String hql = "update Mark m set m.review = :review where m.markId = :markId";
        getSession().createQuery(hql)
                .setInteger("review", mark.getReview())
                .setString("markId", mark.getMarkId())
                .executeUpdate();
    }
}
