package com.yt.dql.model;

public class Classes {
    private Integer cId;

    private String cName;

    private Teacher teacher;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String toString() {
         return "Classes [id=" + cId + ", name=" + cName + ", teacher=" + teacher+ "]";
    }
}