package com.zhao.pojo;
import java.util.*;
public class Course implements  Comparable{
    private int course_id;
    private String course_name;
    private Teacher teacher;
    private List<Course_Value> courseValueList;


    public List<Course_Value> getCourseValueList() {
        return courseValueList;
    }

    public void setCourseValueList(List<Course_Value> courseValueList) {
        this.courseValueList = courseValueList;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object obj) {
        Course course=(Course)obj;
        if(course_id==((Course) obj).course_id)
            return true;
        else
            return false;

    }

    @Override
    public int compareTo(Object o) {
           return course_id-((Course) o).course_id;

    }
}
