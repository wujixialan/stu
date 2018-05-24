package com.stu.entity;

/**
 * Created by zxg on 2018/5/21.
 */
public class Review {
    private String reviewId;
    private String reviewContent;
    private Student student;
    private Mark mark;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewId != null ? !reviewId.equals(review.reviewId) : review.reviewId != null) return false;
        if (reviewContent != null ? !reviewContent.equals(review.reviewContent) : review.reviewContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId != null ? reviewId.hashCode() : 0;
        result = 31 * result + (reviewContent != null ? reviewContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", student=" + student +
                ", mark=" + mark +
                '}';
    }
}
