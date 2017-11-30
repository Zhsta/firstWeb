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
    //ɾ��һ���γ�����Ӧ����������ֵ   ��Ϊ�ҵı���course��coursevalue Ϊһ��һ��ϵ ����ֻ������һ��ɾ��
    //��Ȼ���������ʮ�ִ���� �������ֻ����Ϊ�볢�Բ�ͬ������
    public void delete(int course_id){
        c_valueMapper.delete(course_id);
    }
}
