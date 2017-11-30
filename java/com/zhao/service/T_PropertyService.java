package com.zhao.service;

import com.zhao.mapper.T_PropertyMapper;
import com.zhao.pojo.Teacher_Property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class T_PropertyService {
    @Autowired
    private T_PropertyMapper t_propertyMapper;

    public List<Teacher_Property> getAllByTeacher(int teahcerId){
        return t_propertyMapper.getAllByTeacher(teahcerId);
    }
    public Teacher_Property get(int teacher_property_id){
        return t_propertyMapper.get(teacher_property_id);
    }
    public void delete(int teacherId){
        t_propertyMapper.delete(teacherId);
    }
    public void updata(Teacher_Property teacher_property){
        t_propertyMapper.updata(teacher_property);
    }
    public void add(Teacher_Property teacher_property){
        t_propertyMapper.add(teacher_property);
    }
    public void deleteById(int id){
        t_propertyMapper.deleteById(id);
    }
}
