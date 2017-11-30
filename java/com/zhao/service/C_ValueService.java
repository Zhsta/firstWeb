package com.zhao.service;


import com.zhao.mapper.C_ValueMapper;
import com.zhao.pojo.Course_Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class C_ValueService {
    @Autowired
    private C_ValueMapper c_valueMapper;

    public Course_Value get(int courseId){
       return c_valueMapper.get(courseId);
    }
    public void add( Course_Value course_value){
        c_valueMapper.add(course_value);
    }
    public void update(int courseId,Course_Value course_value){
        c_valueMapper.update(courseId,course_value);
    }
    //删除一个课程所对应的所有属性值   因为我的表中course与coursevalue 为一对一关系 所以只存在这一种删除
    //当然这种设计是十分错误的 这样设计只是因为想尝试不同的做法
    public void delete(int course_id){
        c_valueMapper.delete(course_id);
    }
}
