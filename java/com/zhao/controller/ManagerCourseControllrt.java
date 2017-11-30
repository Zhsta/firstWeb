package com.zhao.controller;
import com.zhao.pojo.Course;
import com.zhao.pojo.Course_Value;
import com.zhao.pojo.Teacher;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseService;
import com.zhao.service.TeacherService;
import com.zhao.util.AddCourseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ManagerCourseControllrt {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private C_ValueService c_valueService;
    @RequestMapping("/ManagerCourseSearchPage")
    public ModelAndView managerCourseSearchPage(){
        ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerCourseSearch");
        modelAndView.addObject("checked", false);
        modelAndView.addObject("teacherIsExist", true);
        return modelAndView;
    }

    @RequestMapping("/ManagerAddCoursePage")
    public ModelAndView addCoursePge(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteCourse");
        modelAndView.addObject("add",true);
        modelAndView.addObject("courseIsExist",true);
        return modelAndView;
    }

    @RequestMapping("/ManagerDeleteCoursePage")
    public ModelAndView deleteCoursePage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteCourse");
        modelAndView.addObject("delete",true);
        modelAndView.addObject("courseIsExist",true);
        return modelAndView;
    }
    @RequestMapping("/ManagerCourseSearch")
    public ModelAndView courseSearch(String courseName,String teacherName){
        Integer teacherId=teacherService.getIdByName(teacherName);
        ModelAndView modelAndView=new ModelAndView();
        if(!isCourseExsit(modelAndView,courseName,teacherName)){
            return modelAndView;
        }
        else {
            Integer courseId = courseService.getId(courseName, teacherId);
            if (courseId != -1) {
                Course course = courseService.get(courseId);
                Course_Value course_value = c_valueService.get( course.getCourse_id() );
                Map<Course, Course_Value> courseAndValue = new HashMap<>();
                courseAndValue.put(course, course_value);
                modelAndView.addObject("courseAndValue", courseAndValue);
                modelAndView.addObject("checked",true);
                modelAndView.setViewName("mainJsp/ManagerCourseSearch");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/ManagerAddCourse")
    public ModelAndView addCourse(AddCourseHelper addCourseHelper) {
           ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteCourse");
           if(isCourseExsit( modelAndView,
                   addCourseHelper.getCourseName(),
                   addCourseHelper.getTeacherName() ) ){
              modelAndView.addObject("countIsExist",true);
              modelAndView.addObject("add",true);
              return modelAndView;
           }
           int teacherId=teacherService.getIdByName( addCourseHelper.getTeacherName() );
           Course course=getCourse(addCourseHelper);
           //将添加过后的id值付给当前的这个course
           courseService.add(course);
           int courseId=courseService.getId( addCourseHelper.getCourseName() ,teacherId);
           course.setCourse_id(courseId);
           //将course付给course——value
           Course_Value course_value=getCourseValue(addCourseHelper);
           course_value.setCourse(course);
           c_valueService.add(course_value);
           modelAndView.addObject("add",true);
           modelAndView.addObject("checked",true);
           modelAndView.addObject("courseIsExist",true);
           modelAndView.addObject("success",true);
           return modelAndView;
    }

    @RequestMapping("/ManagerDeleteCourse")
    public ModelAndView deleteCourse(String courseName,String teacherName){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteCourse");
        if(!isCourseExsit(modelAndView,courseName,teacherName)){
            modelAndView.addObject("countIsExist",true);
            modelAndView.addObject("add",true);
            return modelAndView;
        }
        else{
            int courseId=courseService.getId(courseName,teacherService.getIdByName(teacherName));
            c_valueService.delete(courseId);
            courseService.deleteById(courseId);
        }
        modelAndView.addObject("delete",true);
        modelAndView.addObject("checked",true);
        modelAndView.addObject("courseIsExist",true);
        modelAndView.addObject("success",true);
        return modelAndView;
    }

    @RequestMapping("/ManagerUpdateCoursePage")
    public ModelAndView updateCoursePage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateCourse");
        modelAndView.addObject("courseIsExist",true);
        return  modelAndView;
    }

    @RequestMapping("/ManagerUpdateCourse")
    public ModelAndView updateCourse(AddCourseHelper addCourseHelper){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateCourse");
        if(isCourseExsit(modelAndView,addCourseHelper.getCourseName(),addCourseHelper.getTeacherName())){
            return modelAndView;
        }
        //得到更新后的值
        Course newCourse=getCourse(addCourseHelper);
        Course_Value newCourse_value=getCourseValue(addCourseHelper);

        //得到更新前的值
        Course course=courseService.get(courseService.getId(
                                        newCourse.getCourse_name(),
                                        newCourse.getTeacher().getTeacher_id() ) );
        Course_Value course_value=c_valueService.get(course.getCourse_id());
        //将原来的id值们付给包装了更新值的newCourse和newCourseValue
        newCourse.setCourse_id( course.getCourse_id() );
        newCourse_value.setCourse_value_id( course_value.getCourse_value_id() );
        //更新值
        courseService.updateByCourse( newCourse.getCourse_name() , newCourse.getTeacher().getTeacher_id() );
        c_valueService.update(newCourse.getCourse_id(),course_value);
        modelAndView.addObject("checked",true);
        modelAndView.addObject("courseIsExist",true);
        return modelAndView;
    }
    private Course getCourse(AddCourseHelper addCourseHelper){
        Course course=new Course();
        int teacherId=teacherService.getIdByName( addCourseHelper.getTeacherName() );
        Teacher teacher=teacherService.getById(teacherId);
        course.setTeacher(teacher);
        course.setCourse_name( addCourseHelper.getCourseName() );
        return course;
    }

    private Course_Value getCourseValue(AddCourseHelper addCourseHelper){
              Course_Value course_value=new Course_Value();
              course_value.setClasses( addCourseHelper.getClasses() );
              course_value.setBegin(addCourseHelper.getBegin());
              course_value.setCredit(Integer.parseInt( addCourseHelper.getCredit() ) );
              course_value.setEnd( addCourseHelper.getEnd() );
              course_value.setNumber( addCourseHelper.getNumber() );
              course_value.setTeachername( addCourseHelper.getTeacherName() );
              return course_value;
    }

    private boolean isCourseExsit(ModelAndView modelAndView,String courseName,String teacherName){
        int teacher=teacherService.getIdByName(teacherName);
        int course=courseService.getId(courseName,teacher);
        if(teacher!=-1&&course==-1){
            modelAndView.addObject("checked",false);
            modelAndView.addObject("courseIsExist",false);
            return false;
        }

        return true;
    }

}
