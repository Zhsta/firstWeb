package com.zhao.pojo;

public class Teacher_Property_Value {
    private int teacher_property_value_id;
    private String property_value;
    private Teacher_Property teacher_property;

    public int getTeacher_property_value_id() {
        return teacher_property_value_id;
    }

    public void setTeacher_property_value_id(int teacher_property_value_id) {
        this.teacher_property_value_id = teacher_property_value_id;
    }

    public String getProperty_value() {
        return property_value;
    }

    public void setProperty_value(String property_value) {
        this.property_value = property_value;
    }

    public Teacher_Property getTeacher_property() {
        return teacher_property;
    }

    public void setTeacher_property(Teacher_Property teacher_property) {
        this.teacher_property = teacher_property;
    }
}
