package com.zhao.service;


import com.zhao.mapper.TP_Value;
import com.zhao.pojo.Teacher_Property_Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class TP_ValueService {
    @Autowired
    private TP_Value tp_value;

    public List<Teacher_Property_Value> get(int propertyId){
        return tp_value.get(propertyId);
    }
    public void deleteAllByproperty(int propertyId){
        tp_value.deleteAllByproperty(propertyId);
    }
    public void deleteOneLine(int property_valueId){
        tp_value.deleteOneLine(property_valueId);
    }
    public void add(Teacher_Property_Value teacher_property_value){
        tp_value.add(teacher_property_value);
    }
    public void update(Teacher_Property_Value teacher_property_value){
        tp_value.update(teacher_property_value);
    }
}
