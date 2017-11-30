package com.zhao.service;

import com.zhao.mapper.StudentMapper;
import com.zhao.pojo.Student;
import com.zhao.util.CheckNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public Student get(String userName){
        return studentMapper.get(userName);
    }
    public void delete(int studentId){
        studentMapper.delete(studentId);
    }
    public void update(Student student){
        studentMapper.update(student);
    }
    public void add(Student student){
        studentMapper.add(student);
    }
    public int getId(String userName){
        return CheckNull.returnHandler(studentMapper.getId(userName));
    }
    public boolean isRegist(String username,String password){
        Student student=studentMapper.get(username);
        if(student==null){
            return false;
        }
        else if(password.equals(student.getPassword())){
            return true;
        }
        else
            return false;
    }


}
