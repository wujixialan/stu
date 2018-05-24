package com.stu.entity;

public class Clazz {
    private String cid;
    private String clazzName;
    private String college;
    private String profess;

    public Clazz(String cid) {
    }

    public Clazz() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfess() {
        return profess;
    }

    public void setProfess(String profess) {
        this.profess = profess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (cid != null ? !cid.equals(clazz.cid) : clazz.cid != null) return false;
        if (clazzName != null ? !clazzName.equals(clazz.clazzName) : clazz.clazzName != null) return false;
        if (college != null ? !college.equals(clazz.college) : clazz.college != null) return false;
        if (profess != null ? !profess.equals(clazz.profess) : clazz.profess != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (clazzName != null ? clazzName.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (profess != null ? profess.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid='" + cid + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", college='" + college + '\'' +
                ", profess='" + profess + '\'' +
                '}';
    }
}
