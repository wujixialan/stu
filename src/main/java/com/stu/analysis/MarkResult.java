package com.stu.analysis;

import java.util.Objects;

public class MarkResult {
    /**
     * 学生通过学生的排名
     */
    private int index;
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 班级
     */
    private String clazzName;
    /**
     * 代表学生的平均成绩
     */
    private double avgScore;

    /**
     * 总学分
     */
    private double sumCredit;
    /**
     * 总绩点
     */
    private double sumGpa;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getSumCredit() {
        return sumCredit;
    }

    public void setSumCredit(double sumCredit) {
        this.sumCredit = sumCredit;
    }

    public double getSumGpa() {
        return sumGpa;
    }

    public void setSumGpa(double sumGpa) {
        this.sumGpa = sumGpa;
    }

    @Override
    public String toString() {
        return "MarkResult{" +
                "index=" + index +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", avgScore=" + avgScore +
                ", sumCredit=" + sumCredit +
                ", sumGpa=" + sumGpa +
                '}';
    }
}
