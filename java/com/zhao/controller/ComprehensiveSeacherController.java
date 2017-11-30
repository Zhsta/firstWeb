package com.zhao.controller;


import com.zhao.pojo.Course;
import com.zhao.pojo.Course_Value;
import com.zhao.pojo.Student;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseScoreService;
import com.zhao.service.CourseService;
import com.zhao.service.S_CService;
import com.zhao.service.StudentService;
import com.zhao.service.TeacherService;
import com.zhao.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class ComprehensiveSeacherController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private S_CService s_cService;
    @Autowired
    private CourseScoreService courseScoreService;
    @Autowired
    private C_ValueService c_valueService;
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/ComprehensiveSearch")
    public ModelAndView comprehensiveSearch(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentComprehensiveSearch");
        return modelAndView;
    }

   @RequestMapping("/PassScore")
   public ModelAndView passScore(String username ,String start ){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentPassScore");
        getCourseNameAndScoreAboveJudge(username,
                                        Integer.parseInt(start),modelAndView,
                                        60.0);
        return modelAndView;
   }

   @RequestMapping("/allScore")
   public ModelAndView allScore(String username,String start){
       ModelAndView modelAndView=new ModelAndView("mainJsp/StudentAllScore");
       getCourseNameAndScoreAboveJudge(username,
                                       Integer.parseInt(start),
                                       modelAndView,
                                       0.0);
       return modelAndView;
   }

   private void getCourseNameAndScoreAboveJudge(String username,int start,ModelAndView modelAndView,double judge){
       Page page=new Page();
       double score=0.0;
       int studentId=studentService.getId(username);
       List<Course> courseList=s_cService.getByStudent(studentId);
       List<Course_Value> course_values=new ArrayList<>();

       Map<Course,Double> courseNameAndScore =new HashMap<>();
       for(Course course:courseList){
           score=courseScoreService.get( studentId, course.getCourse_id() );
           if(score>=judge) {
               courseNameAndScore.put(course, score);
               course_values.add(c_valueService.get(  course.getCourse_id() ));
           }
       }
       page.setStart(start);
       page.setTotal(courseNameAndScore.size());
       page.init();
       modelAndView.addObject("page",page);
       modelAndView.addObject("courseValues",course_values);
       modelAndView.addObject("courseNameAndScore",courseNameAndScore);
   }


   @RequestMapping("/CourseArrangement")
    public ModelAndView courseArrangement(String username ,int start){
       ModelAndView modelAndView=new ModelAndView("mainJsp/StudentCourseArrangement");
       Page page=new Page();
       List<Course> courseList=new ArrayList<>();
       Map<Course,Course_Value> course_valueMap=new HashMap<>();
       Student student=studentService.get(username);
       courseList=s_cService.getByStudent(student.getStudent_id());
       for(Course course:courseList){
           Course_Value course_value=c_valueService.get( course.getCourse_id() );
           course_valueMap.put(course,course_value);
       }
       page.setStart(start);
       page.setTotal( course_valueMap.size() );
       page.init();
       modelAndView.addObject("CourseAndValue",course_valueMap);
       modelAndView.addObject("page",page);
       return modelAndView;
   }

     @RequestMapping("/CourseSearch")
     public ModelAndView courseSearch(String courseName,String teacherName){
        Integer teacherId=teacherService.getIdByName(teacherName);
         ModelAndView modelAndView=new ModelAndView();
        if(teacherId==-1){
            modelAndView.setViewName("redirect:/CourseSearchPage?error=0");
        }
        else {
                Integer courseId = courseService.getId(courseName, teacherId);
                if (courseId != -1) {
                    Course course = courseService.get(courseId);
                    Course_Value course_value = c_valueService.get( course.getCourse_id() );
                    Map<String, Course_Value> courseAndValue = new HashMap<>();
                    courseAndValue.put(course.getCourse_name(), course_value);
                    modelAndView.addObject("courseAndValue", courseAndValue);
                    modelAndView.setViewName("mainJsp/StudentCourseSearchResult");
                }
        }
            return modelAndView;
    }


     @RequestMapping("/CourseSearchPage")
      public ModelAndView courseSearchPage(Integer error){
         ModelAndView modelAndView=new ModelAndView("mainJsp/StudentCourseSearchPage");
         if(error!=null){
             modelAndView.addObject("error",error);
         }
         return modelAndView;
     }

}
