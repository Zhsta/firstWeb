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
    //���ݿγ�id����ѧ������
    public List<Student> getByCourse(int courseId){
        return s_cMapper.getByCourse(courseId);
    }
    //����ѧ��id���ؿγ̼���
    public List<Course>  getByStudent(int StudentId){
        return s_cMapper.getByStudent(StudentId);
    }
    //ͨ��ѧ��idɾ��sc���е���Ӧ���м�¼
    public void deleteAllByStudent(int id){
        s_cMapper.deleteAllByStudent(id);
    }
    //ͨ���γ�id ɾ�����е�������Ӧ��¼
    public void deleteAllByCourse(int id){
        s_cMapper.deleteAllByCourse(id);
    }
    //ͨ��ѧ��id ����courseid
    public void deleteOneLine(int studentId,int courseId){
        s_cMapper.deleteOneLine(studentId,courseId);
    }
    public void updateByStudent(int studentId,int courseId){
        s_cMapper.updateByStudent(studentId,courseId);
    }
    //paramע�⴫��������
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
