package com.zhao.mapper;
import java.util.List;

import com.zhao.pojo.*;
public interface T_PropertyMapper {
    List<Teacher_Property> getAllByTeacher(int teahcerId);
    Teacher_Property get(int teacher_property_id);
    void delete(int teacherId);
    void updata(Teacher_Property teacher_property);
    void add(Teacher_Property teacher_property);
    void deleteById(int id);
}
