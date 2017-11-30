package com.zhao.mapper;
import java.util.List;

import com.zhao.pojo.*;

public interface Student_PropertyMapper {
    List<Student_Property> get(int studentId);
    void deleteAll(int studentId);
    void deleteOneLine(int propertyId);
    void update(Student_Property student_property);
    void add(Student_Property student_property_value);
}
