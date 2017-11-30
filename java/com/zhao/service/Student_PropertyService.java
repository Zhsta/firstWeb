package com.zhao.service;

import com.zhao.mapper.Student_PropertyMapper;
import com.zhao.pojo.Student_Property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class Student_PropertyService {
    @Autowired
    private Student_PropertyMapper student_propertyMapper;

    public List<Student_Property> get(int studentId){
        return student_propertyMapper.get(studentId);
    }
    public void deleteAll(int studentId){
        student_propertyMapper.deleteAll(studentId);
    }
    public void deleteOneLine(int propertyId){
        student_propertyMapper.deleteOneLine(propertyId);
    }
    public void update(Student_Property student_property){
         student_propertyMapper.update(student_property);
    }
    public void add(Student_Property student_property_value){
        student_propertyMapper.add(student_property_value);
    }

}
