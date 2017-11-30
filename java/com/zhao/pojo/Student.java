package com.zhao.pojo;

import java.util.List;

public class Student {
    private String username;
    private int student_id;
    private String password;
    private String role;
    private String name;
    List<Student_Property> student_properties;
    List<Course> courses;



    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student_Property> getStudent_properties() {
        return student_properties;
    }

    public void setStudent_properties(List<Student_Property> student_properties) {
        this.student_properties = student_properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
