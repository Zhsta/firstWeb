package com.zhao.service;


import com.zhao.mapper.S_TMapper;
import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class S_TService {
    @Autowired
    private S_TMapper s_tMapper;

    public List<Teacher> getByStudent(int id){
        return s_tMapper.getByStudent(id);
    }//根据学生id返回老师
    public List<Student> getByTeacher(int id){
        return s_tMapper.getByTeacher(id);
    }//根据老师id返回学生
    public void deleteAllByStudent(int id){
        s_tMapper.deleteAllByStudent(id);
    }//通过学生id删除从st表中删除老师信息 目的是为了实现关联删除
    public void deleteOneLine(int studentId,int teacherId){
        s_tMapper.deleteOneLine(studentId,teacherId);
    }

    public void deleteAllByTeacher(int id){
        s_tMapper.deleteAllByStudent(id);

    }//通过老师id从st表中删除学生信息 目的是为了实现关联删除

    //根据学生的id 将st表中的 相对应的teacherid 改为传入的teacherid
    public void updateByStudent(int studentId,int teacherId){
        s_tMapper.updateByStudent(studentId,teacherId);
    }

    //param注解传入多个参数
    //根据老师的id 将st表中的 相对应的studentid 改为传入的studentrid
    public void updateByTeacher(int studentId,int teacherId){
        s_tMapper.updateByTeacher(studentId,teacherId);
    }
    //根据传入的studentid和teacherid在st表中新建一条记录
    public void add(int studentId,int teacherId){
        s_tMapper.add(studentId,teacherId);
    }
}
