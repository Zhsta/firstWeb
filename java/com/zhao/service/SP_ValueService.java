package com.zhao.service;


import com.zhao.mapper.SP_ValueMapper;
import com.zhao.pojo.Student_Property_Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import  java.util.*;
@Service
@Transactional

public class SP_ValueService {
    @Autowired
    private SP_ValueMapper sp_valueMapper;

    public List<Student_Property_Value> get(int SP_Id){
        return sp_valueMapper.get(SP_Id);
    }
    public void delete(int propertyId){
        sp_valueMapper.delete(propertyId);
    }
    public void update(Student_Property_Value student_property_value){
        sp_valueMapper.update(student_property_value);
    }
    public void add(Student_Property_Value student_property_value){
        sp_valueMapper.add(student_property_value);
    }

}
