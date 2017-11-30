package com.zhao.pojo;

import java.util.List;

public class Teacher_Property {
    private int teacher_property_id;
    private Teacher teacher;
    private String property_name;
    List<Teacher_Property_Value> teacherPropertyValues;

    public List<Teacher_Property_Value> getTeacherPropertyValues() {
        return teacherPropertyValues;
    }

    public void setTeacherPropertyValues(List<Teacher_Property_Value> teacherPropertyValues) {
        this.teacherPropertyValues = teacherPropertyValues;
    }

    public int getTeacher_property_id() {
        return teacher_property_id;
    }

    public void setTeacher_property_id(int teacher_property_id) {
        this.teacher_property_id = teacher_property_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getProperty_name() {

        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }
}
