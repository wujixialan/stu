package com.stu.services;

import com.stu.analysis.MarkResult;
import com.stu.entity.Mark;
import com.stu.entity.User;

import java.util.List;
import java.util.Map;

public interface MarkService {
    /**
     * 成绩的添加。
     * @param mark
     */
    public void markAdd(Mark mark);

    /**
     * 查询所有成绩
     * @return
     * @param user
     * @param page
     * @param limit
     * @param mark
     */
    public List<Mark> findAllMark(User user, int page, int limit, Mark mark);

    /**
     * 查看所有成绩的记录
     * @return
     * @param user
     * @param mark
     */
    public long getMarkTotal(User user, Mark mark);


    /**
     * 通过 subjectId 查找成绩
     * @param subjectId: 课程编号
     * @param sid：学号
     * @return
     */
    public Mark findMarkBySubjectId(String subjectId, String sid);

    /**
     * 更新成绩
     * @param mark
     */
    public void markEdit(Mark mark);

    /**
     * 通过学生的学号，获取该学生的成绩记录的总数
     * @param sid
     * @return
     */
    public long getMarkTotalBySid(String sid);

    /**
     * 通过学生 sid，获取该学生的成绩记录
     * @param sid：学生的学号
     * @return
     */
    public List<Mark> getMarkBySid(String sid);

    /**
     * 获取成绩排名信息。
     */
    public Map<String, MarkResult> getMarkResult();

    /**
     * 根据 sid 删除 Mark。
     * @param marks
     */
    public void delMarks(List<Mark> marks);

    /**
     * 删除单个的 Mark。
     * @param mark
     */
    public void delMark(Mark mark);

    /**
     * 更新审核状态
     * @param mark
     */
    public void updateReview(Mark mark);
}
