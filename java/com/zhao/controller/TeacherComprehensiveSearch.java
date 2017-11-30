package com.zhao.controller;
import com.zhao.pojo.Course;
import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;
import com.zhao.service.CourseService;
import com.zhao.service.S_CService;
import com.zhao.service.StudentService;
import com.zhao.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class TeacherComprehensiveSearch {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private S_CService s_cService;

    @RequestMapping("/TeacherComprehensiveSearch")
    public ModelAndView search(String username,String teacherName){
        ModelAndView modelAndView=new ModelAndView("mainJsp/TeacherSearchPage");
        int teacherId=teacherService.getIdByName(teacherName);
        int studentId=studentService.getId(username);
        //通过老师的ID得到老师教授的所有课程
        List<Course> teacherCourses=courseService.getCourseByTeacher(teacherId);
        //得到学生课程
        List<Course> studentCourse=s_cService.getByStudent(studentId);
        List<Course> sc=new ArrayList<>();
        boolean find=false;
        //双重循环 找到
            for(Course course:teacherCourses){
                  for(Course course1:studentCourse){
                     if( course.getCourse_id() == course1.getCourse_id() ){
                         sc.add(course);
                         find=true;
                     }
                  }
              }
        Student student=studentService.get(username);
        modelAndView.addObject("find",find);
        modelAndView.addObject("student",student);
        if(find==false) {
            modelAndView.addObject("studentIsExist", false);
        }
        modelAndView.addObject("Course",sc);
        return modelAndView;
    }

    @RequestMapping("/TeacherComprehensiveSearchPage")
    public ModelAndView Page(HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView("mainJsp/TeacherSearchPage");
        Teacher teacher=(Teacher)httpSession.getAttribute("user");
        modelAndView.addObject("teacherName",teacher.getName() );
        return modelAndView;
    }
}
