package com.zhao.service;


import com.zhao.mapper.CourseScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CourseScoreService {
    @Autowired
    private CourseScore courseScore;
    public void add(int student_id, int course_id,double score){
        courseScore.add(student_id,course_id,score);
    }

    //只可能根据student——id来更改
    public void update( int student_id,int course_id,double score){
        courseScore.update(student_id,course_id,score);
    }
    public double get( int student_id,int course_id){
        Double d=courseScore.get(student_id,course_id);
        if(d==null){
            d=-1.0;
        }
        return d;
    }
    public void delete(int student_id,int course_id){
        courseScore.delete(student_id,course_id);
    }
    public void deleteAllByStudentId( int studentId){
        courseScore.deleteAllByStudentId(studentId);
    }
    public void deleteAllByCourseId( int course_id){
        courseScore.deleteAllByCourseId(course_id);
    }
}
