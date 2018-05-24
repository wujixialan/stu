package com.stu.analysis;

/**
 * 成绩分析模型
 */
public class MarkAnalysisModel {
    /**
     * 平均成绩
     */
    private double score;
    /**
     * 是否挂科
     * 0：代表否
     * 1：代表是
     * 挂科几科
     */
    private int hang;
    /**
     * 总学分
     */
    private double credit;
    /**
     * 平均绩点
     */
    private double gpa;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "MarkAnalysisModel{" +
                "score=" + score +
                ", hang=" + hang +
                ", credit=" + credit +
                ", gpa=" + gpa +
                '}';
    }
}
