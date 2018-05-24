package com.stu.dao;

import com.stu.entity.Student;
import com.stu.entity.User;

import java.util.List;

public interface StudentDao {
    /**
     * 获取所有的学生信息
     * @return
     * @param page
     * @param limit
     */
    public List<Student> getAllStudent();

    /**
     * 获取学生的所有记录
     * @return
     */
    public long getStudentTotal(Student student, User user);

    /**
     * 根据 sid 查询一个学生的信息。
     * @param sid：需要查询的学生 id
     * @return：需要返回一个学生的对象。
     */
    public Student findStudent(String sid);

    /**
     * 添加学生的基本信息
     *
     * @param student : 要添加的 Student 对象。
     */
    public void stuAdd(Student Student);

    public List<Student> getAllPageStudent(int page, int limit, Student student, User user);

    /**
     * 通过学生姓名查询 id；
     * @param student
     * @return
     */
    public Student findByName(Student student);

    /**
     * 删除学生信息
     * @param stu
     */
    public void delStu(Student stu);

    /**
     * 对学生基本信息的审核。
     * @param student
     */
    public void updateReview(Student student);
}
