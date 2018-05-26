package com.stu.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Mark {
    private String markId;
    /**
     * 科目编号
     */
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "课程编号填写不正确")
    private String subjectId;
    /**
     * 科目名称
     */
    @NotBlank
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z]+$", message = "课程名称可以是中英文")
    private String subjectName;
    /**
     * 成绩
     */
    private Double score;
    /**
     * 是否挂科
     */
    private String hang;
    /**
     * 是否为初修
     */
    private String study;
    /**
     * 学科类型
     */
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "学科类型填写不正确")
    private String subjectType;
    /**
     * 学期
     */
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9\\-\\s]+$", message = "学期填写不正确")
    private String team;
    /**
     * 学分
     */
    private Double credit;
    /**
     * 绩点
     */
    private Double gpa;

    private Student student;
    private Integer reviewId;

    @Override
    public String toString() {
        return "Mark{" +
                "markId='" + markId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", score=" + score +
                ", hang='" + hang + '\'' +
                ", study='" + study + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", team='" + team + '\'' +
                ", credit=" + credit +
                ", gpa=" + gpa +
                ", student=" + student +
                ", reviewId=" + reviewId +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(subjectId, mark.subjectId) &&
                Objects.equals(subjectName, mark.subjectName) &&
                Objects.equals(score, mark.score) &&
                Objects.equals(hang, mark.hang) &&
                Objects.equals(study, mark.study) &&
                Objects.equals(subjectType, mark.subjectType) &&
                Objects.equals(team, mark.team) &&
                Objects.equals(credit, mark.credit) &&
                Objects.equals(gpa, mark.gpa);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectId, subjectName, score, hang, study, subjectType, team, credit, gpa);
    }

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Mark(String markId) {
        this.markId = markId;
    }

    public Mark() {
    }
}
