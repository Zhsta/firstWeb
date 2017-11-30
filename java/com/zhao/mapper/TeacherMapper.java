package com.zhao.mapper;
import com.zhao.pojo.*;
public interface TeacherMapper {
    Teacher get(String userName);
    void delete(String userName);
    void  update(Teacher student);
    void add(Teacher student);
    Integer getId(String userName);
    Integer getIdByName(String teacherName);
    Teacher getById(int id);
}
