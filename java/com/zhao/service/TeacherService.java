package com.zhao.service;

import com.zhao.mapper.TeacherMapper;
import com.zhao.pojo.Teacher;
import com.zhao.util.CheckNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    public Teacher get(String userName){
       return teacherMapper.get(userName);
    }
    public void delete(String userName){
        teacherMapper.delete(userName);
    }
    public void  update(Teacher student){
        teacherMapper.update(student);
    }
    public void add(Teacher teacher){
        teacherMapper.add(teacher);
    }
    public int getId(String userName){

        return  CheckNull.returnHandler(teacherMapper.getId(userName));
    }
    public boolean isRegist(String username,String password){
        Teacher teacher=teacherMapper.get(username);
        if(teacher==null){
            return false;
        }
        else if(password.equals(teacher.getPassword())){
            return true;
        }
        else
            return false;
    }
    public int getIdByName(String teacherName){
        return  CheckNull.returnHandler(teacherMapper.getIdByName(teacherName));
    }
    public Teacher getById(int id){
        return teacherMapper.getById(id);
    }
}
