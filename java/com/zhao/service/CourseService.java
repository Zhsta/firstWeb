package com.zhao.service;

import com.zhao.mapper.CourseMapper;
import com.zhao.pojo.Course;
import com.zhao.util.CheckNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
@Transactional

public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public Course get(int id){
        return courseMapper.get(id);
    }

    public int getId(String  courseName,int teacherId){
        return CheckNull.returnHandler(courseMapper.getId(courseName,teacherId));
    }
    //根据coursename 删除记录
    public void delete(String courseName){
        courseMapper.delete(courseName);
    }
    //增添
    public void add(Course course){
        courseMapper.add(course);
    }
    //更新;
    public void updateByCourse(String course_name,int teacher_id){
        courseMapper.updateByCourse(course_name,teacher_id);
    }
    public void updateByTeacher(int teacher_id,String course_name){
        courseMapper.updateByTeacher(teacher_id,course_name);
    }
    public List<Course> listAllCourse(){
        List<Course> list=courseMapper.listAllCourse();
        Collections.sort(list);
        return list;
    }
    public List<Course> getCourseByTeacher(int teacherId){

        return courseMapper.getCourseByTeacher(teacherId);
    }
    public void deleteById(int courseId){
        courseMapper.deleteById(courseId);
    }

}
