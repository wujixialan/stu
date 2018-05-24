package com.stu.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
/**
 * Created by zxg on 2018/5/24.
 */
public class Student {
    @NotBlank
    @Pattern(regexp = "^[\\d+]{12,12}$", message = "学号只能为数字")
    private String sid;
    @NotBlank
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z]+$", message = "姓名只能为中英文，下划线等")
    private String name;
    private String gender;
    private String nation;
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$", message = "生源地可以为中文字母数字等")
    private String origin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$", message = "身份证号填写不正确")
    private String idCard;
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$", message = "家庭住址可以为中文字母数字等")
    private String address;
    private String photo;
    private Integer reviewId;
    private String reviewContent;
    private Clazz clazz;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sid != null ? !sid.equals(student.sid) : student.sid != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (gender != null ? !gender.equals(student.gender) : student.gender != null) return false;
        if (nation != null ? !nation.equals(student.nation) : student.nation != null) return false;
        if (origin != null ? !origin.equals(student.origin) : student.origin != null) return false;
        if (birth != null ? !birth.equals(student.birth) : student.birth != null) return false;
        if (idCard != null ? !idCard.equals(student.idCard) : student.idCard != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (photo != null ? !photo.equals(student.photo) : student.photo != null) return false;
        if (reviewId != null ? !reviewId.equals(student.reviewId) : student.reviewId != null) return false;
        if (reviewContent != null ? !reviewContent.equals(student.reviewContent) : student.reviewContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (reviewId != null ? reviewId.hashCode() : 0);
        result = 31 * result + (reviewContent != null ? reviewContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", nation='" + nation + '\'' +
                ", origin='" + origin + '\'' +
                ", birth=" + birth +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                ", reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public Student(@NotBlank @Pattern(regexp = "^[\\d+]{12,12}$", message = "学号只能为数字") String sid) {
        this.sid = sid;
    }

    public Student() {

    }
}
