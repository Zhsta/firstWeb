package com.zhao.service;


import com.zhao.mapper.S_CMapper;
import com.zhao.pojo.Course;
import com.zhao.pojo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class S_CService {
    @Autowired
    private S_CMapper s_cMapper;
    //根据课程id返回学生集合
    public List<Student> getByCourse(int courseId){
        return s_cMapper.getByCourse(courseId);
    }
    //根据学生id返回课程集合
    public List<Course>  getByStudent(int StudentId){
        return s_cMapper.getByStudent(StudentId);
    }
    //通过学生id删除sc表中的相应所有记录
    public void deleteAllByStudent(int id){
        s_cMapper.deleteAllByStudent(id);
    }
    //通过课程id 删除表中的所有相应记录
    public void deleteAllByCourse(int id){
        s_cMapper.deleteAllByCourse(id);
    }
    //通过学生id 更新courseid
    public void deleteOneLine(int studentId,int courseId){
        s_cMapper.deleteOneLine(studentId,courseId);
    }
    public void updateByStudent(int studentId,int courseId){
        s_cMapper.updateByStudent(studentId,courseId);
    }
    //param注解传入多个参数
    public void updateByCourse(int studentId,int courseId){
        s_cMapper.updateByCourse(studentId,courseId);
    }
    public void add(int studentId,int courseId){
        s_cMapper.add(studentId,courseId);
    }
    public boolean IsExist(int studentId,int courseId){
        Integer integer=s_cMapper.get(studentId,courseId);
        if(integer==null||integer!=courseId){
            return false;
        }
        return true;
    }
}
