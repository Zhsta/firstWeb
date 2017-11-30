package com.zhao.controller;


import com.zhao.pojo.Student;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseScoreService;
import com.zhao.service.CourseService;
import com.zhao.service.S_CService;
import com.zhao.service.StudentService;
import com.zhao.service.TP_ValueService;
import com.zhao.service.T_PropertyService;
import com.zhao.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherCourseManageController {
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
    @Autowired
    private S_CService s_cService;
    @Autowired
    private CourseScoreService courseScoreService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/CourseStudentList")
    public ModelAndView  courseStudentList(int courseId){
         ModelAndView modelAndView=new ModelAndView("mainJsp/TeacherStudentInCourseList");
         List<Student> studentList=s_cService.getByCourse(courseId);
        Map<Student,Double> studentAndScore=new HashMap<>();
         for(Student student:studentList){
                studentAndScore.put(student,courseScoreService.get(student.getStudent_id(),courseId));
         }

         modelAndView.addObject("studentAndScore",studentAndScore);
         modelAndView.addObject("courseId",courseId);
         return modelAndView;
    }

    @RequestMapping("/addGrade")
    public ModelAndView addGrade(double grade,int studentId,int courseId){
        courseScoreService.add(studentId,courseId,grade);
        ModelAndView modelAndView=new ModelAndView("redirect:/CourseStudentList?courseId="+courseId);
        return modelAndView;
    }

    @RequestMapping("/TeacherDeleteStudent")
    public ModelAndView deleteStudent(String username,int courseId){
        ModelAndView modelAndView=new ModelAndView("redirect:/CourseStudentList?courseId="+courseId);
        Student student=studentService.get(username);
        s_cService.deleteOneLine(student.getStudent_id(),courseId);
        courseScoreService.delete(student.getStudent_id(),courseId);
        return modelAndView;
    }
}
