package com.stu.services;

import com.stu.entity.Student;
import com.stu.entity.User;

import java.util.List;

public interface StudentService {
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
     * @param student: 要添加的 Student 对象。
     */
    public void stuAdd(Student student);

    /**
     * 判断学生是否注册。
     * @param student：传入的学生对象
     * @return：如果返回 true，则未注册，否则已经注册
     */
    public boolean isSid(Student student);

    /**
     * 修改学生信息。
     * @param student: 修改学生信息的对象
     */
    public void stuEdit(Student student);

    /**
     * 通过分页获取学生信息
     * @param page ：当前页
     * @param limit ：一页有多少数据
     * @param student
     * @param user
     * @return
     */
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
}
