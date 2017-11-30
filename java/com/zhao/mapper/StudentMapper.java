package com.zhao.mapper;
import com.zhao.pojo.*;public interface StudentMapper {
    Student get(String userName);
    void delete(int studentId);
    void  update(Student student);
    void add(Student student);
    Integer getId(String userName);

}
