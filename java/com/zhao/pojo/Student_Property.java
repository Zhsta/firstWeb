package com.zhao.pojo;

import java.util.List;

public class Student_Property {
    private int property_id;
    private String property_name;
    private Student student;
    private List<Student_Property_Value> student_property_values;

    public List<Student_Property_Value> getStudent_property_values() {
        return student_property_values;
    }

    public void setStudent_property_values(List<Student_Property_Value> student_property_values) {
        this.student_property_values = student_property_values;
    }

    public Student getStudent() {
       return student;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}