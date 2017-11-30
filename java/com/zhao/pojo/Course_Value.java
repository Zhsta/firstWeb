package com.zhao.pojo;

import java.sql.Date;

public class Course_Value {
    private int course_value_id;
    private Date begin;
    private Date end;
    private int credit;
    private Course course;
    private String classes;
    private String number;
    private String teachername;

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getCourse_value_id() {
        return course_value_id;
    }

    public void setCourse_value_id(int course_value_id) {
        this.course_value_id = course_value_id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
