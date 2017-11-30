package com.zhao.controller;

import com.zhao.pojo.Course;
import com.zhao.pojo.Course_Value;
import com.zhao.pojo.Teacher;
import com.zhao.pojo.Teacher_Property;
import com.zhao.pojo.Teacher_Property_Value;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseService;
import com.zhao.service.TP_ValueService;
import com.zhao.service.T_PropertyService;
import com.zhao.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class TeacherHomePageController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private T_PropertyService t_propertyService;
    @Autowired
    private TP_ValueService tp_valueService;
    @Autowired
    private C_ValueService c_valueService;
    @RequestMapping("/TeacherManage")
    public ModelAndView teacherManage(String username,String name){
        ModelAndView modelAndView=new ModelAndView();
             Teacher teacher=teacherService.get(username);
             List<Teacher_Property> teacher_propertyList=t_propertyService.getAllByTeacher(teacher.getTeacher_id());
             Map<String,String>TP_and_tpValue=new HashMap<>();
             for(Teacher_Property teacher_property:teacher_propertyList) {
                 addValueToMap(TP_and_tpValue,teacher_property);
             }
             modelAndView.addObject("propertyAndValue",TP_and_tpValue);
             modelAndView.setViewName("mainJsp/TeacherManage");
             return  modelAndView;
    }
    public void addValueToMap(Map<String,String>propertyAndValue,Teacher_Property teacher_property ){
        List<Teacher_Property_Value>student_property_values=tp_valueService.get(teacher_property.getTeacher_property_id());
        StringBuilder stringBuilder=new StringBuilder();
        for(Teacher_Property_Value spv:student_property_values){
            stringBuilder.append(spv.getProperty_value()+"\n");
        }
        propertyAndValue.put(teacher_property.getProperty_name(),stringBuilder.toString());
    }


    @RequestMapping("/TeacherCourseManage")
    public ModelAndView teacherCourseManage(String username){
        ModelAndView modelAndView=new ModelAndView("mainJsp/TeacherCourseManage");
        Teacher teacher=teacherService.get(username);
        List<Course> courseList= courseService.getCourseByTeacher(teacher.getTeacher_id());
        Collections.sort(courseList);
        Map<Course,Course_Value>CourseAndValue=new TreeMap<>();
        for(Course course:courseList){
            Course_Value course_value=c_valueService.get(course.getCourse_id());
            CourseAndValue.put(course,course_value);
        }
        modelAndView.addObject("CourseAndValue",CourseAndValue);
        return modelAndView;
    }

    @RequestMapping("/TeacherHomePage")
    public String teacherHomePage(){
        return "mainJsp/TeacherHomePage";
    }
}
