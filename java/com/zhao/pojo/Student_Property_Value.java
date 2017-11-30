package com.zhao.pojo;

public class Student_Property_Value {
    private int student_property_value_id;
    private String value;
    private Student_Property student_property;

    public int getStudent_property_value_id() {
        return student_property_value_id;
    }

    public void setStudent_property_value_id(int student_property_value_id) {
        this.student_property_value_id = student_property_value_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Student_Property getStudent_property() {
        return student_property;
    }

    public void setStudent_property(Student_Property student_property) {
        this.student_property = student_property;
    }
}
