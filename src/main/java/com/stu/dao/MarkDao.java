package com.stu.dao;

import com.stu.analysis.MarkResult;
import com.stu.entity.Mark;
import com.stu.entity.Review;
import com.stu.entity.User;

import java.util.List;
import java.util.Map;

public interface MarkDao {
    public void markAdd(Mark mark);

    public List<Mark> findAllMark(User user, int page, int limit, Mark mark);

    public long getMarkTotal(User user, Mark mark);

    public Mark findMarkBySubjectId(String subjectId, String sid);

    public long getMarkTotalBySid(String sid);

    public List<Mark> getMarkBySid(String sid);

    public Map<String, MarkResult> getMarkResult();

    public void delMarks(List<Mark> marks);

    public void delMark(Mark mark);

    public void review(Review review);

    public void updateReview(Mark mark);
}
