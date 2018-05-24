package com.stu.services.impl;

import com.stu.dao.StudentDao;
import com.stu.entity.Student;
import com.stu.entity.User;
import com.stu.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 获取所有的学生信息
     *
     * @return
     */
    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) studentDao.getAllStudent();
    }

    /**
     * 获取学生的所有记录
     *
     * @return
     */
    @Override
    public long getStudentTotal(Student student, User user) {
        return studentDao.getStudentTotal(student, user);
    }

    /**
     * 根据 sid 查询一个学生的信息。
     *
     * @param sid ：需要查询的学生 id
     * @return：需要返回一个学生的对象。
     */
    @Override
    public Student findStudent(String sid) {
        return studentDao.findStudent(sid);
    }

    /**
     * 添加学生的基本信息
     *
     * @param student : 要添加的 Student 对象。
     */
    @Override
    public void stuAdd(Student student) {
        studentDao.stuAdd(student);
    }

    /**
     * 判断学生是否注册。
     *
     * @param student ：传入的学生对象
     * @return：如果返回 true，则未注册，否则已经注册
     */
    @Override
    public boolean isSid(Student student) {
        Student findStudent = studentDao.findStudent(student.getSid());
        if (findStudent == null) {
            return true;
        }
        return false;
    }

    /**
     * 修改学生信息。
     *
     * @param student : 修改学生信息的对象
     */
    @Override
    public void stuEdit(Student student) {
        studentDao.stuAdd(student);
    }

    /**
     * 分页获取学生信息
     *
     * @return
     * @param page
     * @param limit
     * @param student
     * @param user
     */
    @Override
    public List<Student> getAllPageStudent(int page, int limit, Student student, User user) {
        return studentDao.getAllPageStudent(page, limit, student, user);
    }


    /**
     * 通过学生姓名查询 id；
     *
     * @param student
     * @return
     */
    @Override
    public Student findByName(Student student) {
        return studentDao.findByName(student);
    }

    /**
     * 删除学生信息
     *
     * @param stu
     */
    @Override
    public void delStu(Student stu) {
        studentDao.delStu(stu);
    }
}
