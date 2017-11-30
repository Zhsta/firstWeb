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
    }//����ѧ��id������ʦ
    public List<Student> getByTeacher(int id){
        return s_tMapper.getByTeacher(id);
    }//������ʦid����ѧ��
    public void deleteAllByStudent(int id){
        s_tMapper.deleteAllByStudent(id);
    }//ͨ��ѧ��idɾ����st����ɾ����ʦ��Ϣ Ŀ����Ϊ��ʵ�ֹ���ɾ��
    public void deleteOneLine(int studentId,int teacherId){
        s_tMapper.deleteOneLine(studentId,teacherId);
    }

    public void deleteAllByTeacher(int id){
        s_tMapper.deleteAllByStudent(id);

    }//ͨ����ʦid��st����ɾ��ѧ����Ϣ Ŀ����Ϊ��ʵ�ֹ���ɾ��

    //����ѧ����id ��st���е� ���Ӧ��teacherid ��Ϊ�����teacherid
    public void updateByStudent(int studentId,int teacherId){
        s_tMapper.updateByStudent(studentId,teacherId);
    }

    //paramע�⴫��������
    //������ʦ��id ��st���е� ���Ӧ��studentid ��Ϊ�����studentrid
    public void updateByTeacher(int studentId,int teacherId){
        s_tMapper.updateByTeacher(studentId,teacherId);
    }
    //���ݴ����studentid��teacherid��st�����½�һ����¼
    public void add(int studentId,int teacherId){
        s_tMapper.add(studentId,teacherId);
    }
}
