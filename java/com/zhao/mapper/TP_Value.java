package com.zhao.mapper;
import java.util.List;

import com.zhao.pojo.*;

public interface TP_Value {
   List<Teacher_Property_Value> get(int propertyId);
    void deleteAllByproperty(int propertyId);
    void deleteOneLine(int property_valueId);
    void add(Teacher_Property_Value teacher_property_value);
    void update(Teacher_Property_Value teacher_property_value);
}
