package com.stu.services.impl;

import com.stu.analysis.MarkResult;
import com.stu.dao.MarkDao;
import com.stu.entity.Mark;
import com.stu.entity.User;
import com.stu.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkDao markDao;

    /**
     * 成绩的添加。
     *
     * @param mark
     */
    @Override
    public void markAdd(Mark mark) {
        markDao.markAdd(mark);
    }

    /**
     * 查询所有成绩
     *
     * @return
     * @param user
     * @param page
     * @param limit
     * @param mark
     */
    @Override
    public List<Mark> findAllMark(User user, int page, int limit, Mark mark) {
        return markDao.findAllMark(user, page, limit, mark);
    }

    /**
     * 查看所有成绩的记录
     *
     * @return
     * @param user
     * @param mark
     */
    @Override
    public long getMarkTotal(User user, Mark mark) {
        return markDao.getMarkTotal(user, mark);
    }

    /**
     * 通过 subjectId 查找成绩
     *
     * @param subjectId : 课程编号
     * @param sid       ：学号
     * @return
     */
    @Override
    public Mark findMarkBySubjectId(String subjectId, String sid) {
        return markDao.findMarkBySubjectId(subjectId, sid);
    }

    /**
     * 更新成绩
     *
     * @param mark
     */
    @Override
    public void markEdit(Mark mark) {
        markDao.markAdd(mark);
    }

    /**
     * 通过学生的学号，获取该学生的成绩记录的总数
     *
     * @param sid
     * @return
     */
    @Override
    public long getMarkTotalBySid(String sid) {
        return markDao.getMarkTotalBySid(sid);
    }

    /**
     * 通过学生 sid，获取该学生的成绩记录
     *
     * @param sid ：学生的学号
     * @return
     */
    @Override
    public List<Mark> getMarkBySid(String sid) {
        return markDao.getMarkBySid(sid);
    }

    /**
     * 获取成绩排名信息。
     */
    @Override
    public Map<String, MarkResult> getMarkResult() {
        return markDao.getMarkResult();
    }

    /**
     * 根据 sid 删除 Mark。
     *
     * @param marks
     */
    @Override
    public void delMarks(List<Mark> marks) {
        markDao.delMarks(marks);
    }

    /**
     * 删除单个的 Mark。
     *
     * @param mark
     */
    @Override
    public void delMark(Mark mark) {
        markDao.delMark(mark);
    }


    /**
     * 更新审核状态
     *
     * @param mark
     */
    @Override
    public void updateReview(Mark mark) {
        markDao.updateReview(mark);
    }
}
