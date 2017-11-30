package com.zhao.mapper;
import java.util.List;

import com.zhao.pojo.*;
public interface SP_ValueMapper {
    List<Student_Property_Value> get(int SP_Id);
    void delete(int propertyId);
    void update(Student_Property_Value student_property_value);
    void add(Student_Property_Value student_property_value);
}
