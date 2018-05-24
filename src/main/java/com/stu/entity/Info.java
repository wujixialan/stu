package com.stu.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Info {
    private String infoId;
    private String infoTitle;
    private String infoContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date infoTime;
    private String infoType;
    private User user;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (infoId != null ? !infoId.equals(info.infoId) : info.infoId != null) return false;
        if (infoTitle != null ? !infoTitle.equals(info.infoTitle) : info.infoTitle != null) return false;
        if (infoContent != null ? !infoContent.equals(info.infoContent) : info.infoContent != null) return false;
        if (infoTime != null ? !infoTime.equals(info.infoTime) : info.infoTime != null) return false;
        if (infoType != null ? !infoType.equals(info.infoType) : info.infoType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = infoId != null ? infoId.hashCode() : 0;
        result = 31 * result + (infoTitle != null ? infoTitle.hashCode() : 0);
        result = 31 * result + (infoContent != null ? infoContent.hashCode() : 0);
        result = 31 * result + (infoTime != null ? infoTime.hashCode() : 0);
        result = 31 * result + (infoType != null ? infoType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Info{" +
                "infoId='" + infoId + '\'' +
                ", infoTitle='" + infoTitle + '\'' +
                ", infoContent='" + infoContent + '\'' +
                ", infoTime=" + infoTime +
                ", infoType='" + infoType + '\'' +
                ", user=" + user +
                '}';
    }
}
