package com.zhao.controller;
import com.zhao.pojo.Course;
import com.zhao.pojo.Course_Value;
import com.zhao.pojo.Student;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseService;
import com.zhao.service.S_CService;
import com.zhao.service.StudentService;
import com.zhao.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class CourseManageController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private S_CService s_cService;
    @Autowired
    private C_ValueService c_valueService;
    @Autowired
    private CourseService courseService;
    @RequestMapping("/CourseList")
    public ModelAndView personCourse(String username,int start){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentPersonCourse");
        Page page=new Page();
        List<Course> courseList=new ArrayList<>();
        Map<Course,Course_Value> course_valueMap=new HashMap<>();
        Student student=studentService.get(username);
        courseList=s_cService.getByStudent( student.getStudent_id() );
        for(Course course:courseList){
            Course_Value course_value=c_valueService.get( course.getCourse_id() );
            course_valueMap.put( course, course_value );
        }
        page.setStart(start);
        page.setTotal( course_valueMap.size() );
        page.init();
        modelAndView.addObject("CourseAndValue",course_valueMap);
        modelAndView.addObject("page",page);
        return modelAndView;
    }


    @RequestMapping("/notChoosedCourseList")
    public ModelAndView courseSelect(String username,int start){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentCourseChoose");
        Page page=new Page();
        Student student=studentService.get(username);
        int studentId=student.getStudent_id();
        List<Course>hasChoosedCourses=s_cService.getByStudent(studentId);
        Collections.sort(hasChoosedCourses);
        List<Course>allCourses=courseService.listAllCourse();
        Collections.sort(allCourses);
        Map<Course,Course_Value> notChooseCourseAndValueMap=new TreeMap<>();
        for(Course course:allCourses){
            if(hasChoosedCourses.contains(course)==false){
                notChooseCourseAndValueMap.put(course,c_valueService.get ( course.getCourse_id() ) );
            }
        }
        page.setStart(start);
        page.setTotal(notChooseCourseAndValueMap.size());
        page.init();
        modelAndView.addObject("page",page);
        modelAndView.addObject("notChooseCourseAndValue",notChooseCourseAndValueMap);
        return modelAndView;
    }

    @RequestMapping("/addCourse")
    public ModelAndView addCourse(String username,int courseId){
        ModelAndView modelAndView=new ModelAndView("redirect:/notChoosedCourseList"+
                                                              "?username="+username +
                                                              "&start="+0);
        Student student=studentService.get(username);
        if(!s_cService.IsExist( student.getStudent_id() ,courseId)) {
            s_cService.add( student.getStudent_id() , courseId);
        }
        return modelAndView;
    }

   @RequestMapping("/CourseManage")
    public ModelAndView courseManagePage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentCourseManage");
        return modelAndView;
   }

   @RequestMapping("/deleteCourse")
    public ModelAndView deleteCourse(String username,int courseId){
        ModelAndView modelAndView=new ModelAndView("redirect:/CourseList?username="
                                                               +username+"&start="+0);
        int studentId=studentService.getId(username);
        s_cService.deleteOneLine(studentId,courseId);
        return modelAndView;
   }
}
