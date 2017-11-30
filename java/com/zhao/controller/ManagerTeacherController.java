package com.zhao.controller;

import com.zhao.pojo.Course;
import com.zhao.pojo.Manager;
import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;
import com.zhao.pojo.Teacher_Property;
import com.zhao.pojo.Teacher_Property_Value;
import com.zhao.service.C_ValueService;
import com.zhao.service.CourseScoreService;
import com.zhao.service.CourseService;
import com.zhao.service.ManagerService;
import com.zhao.service.SP_ValueService;
import com.zhao.service.S_CService;
import com.zhao.service.S_TService;
import com.zhao.service.StudentService;
import com.zhao.service.Student_PropertyService;
import com.zhao.service.TP_ValueService;
import com.zhao.service.T_PropertyService;
import com.zhao.service.TeacherService;
import com.zhao.util.TeacherPropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerTeacherController {
    @Autowired
    private TP_ValueService tp_valueService;
    @Autowired
    private T_PropertyService t_propertyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseScoreService courseScoreService;
    @Autowired
    private S_TService s_tService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private S_CService s_cService;
    @Autowired
    private Student_PropertyService student_propertyService;
    @Autowired
    private SP_ValueService sp_valueService;
    @Autowired
    private C_ValueService c_valueService;
    @Autowired
    private ManagerService managerService;


    @RequestMapping("/TeacherSearchPage")
    public ModelAndView teacherSearchPage() {
        ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerTeacherControl");
        modelAndView.addObject("checked", false);
        modelAndView.addObject("teacherIsExist", true);
        return modelAndView;
    }

    @RequestMapping("/updateTeacher")
    public ModelAndView updateStudentPage() {
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateTeacher");
        modelAndView.addObject("teacherIsExist",true);
        return modelAndView;
    }

    @RequestMapping("/TeacherSearch")
    public ModelAndView studentSearch(String username) {
        boolean teacherIsExsit = false;
        boolean checked = false;
        ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerTeacherControl");
        Teacher teacher = teacherService.get(username);
        if (teacher == null) {
            modelAndView.addObject("teacherIsExist", teacherIsExsit);
            return modelAndView;
        }
        teacherIsExsit = true;
        checked = true;
        Map<String, String> propertyAndValue = new HashMap<>();
        List<Teacher_Property> teacher_properties = t_propertyService.getAllByTeacher(teacherService.getId(username));
        for (Teacher_Property tp : teacher_properties) {
            addValueToMap(propertyAndValue, tp);
        }
        modelAndView.addObject("checked",checked);
        modelAndView.addObject("teacherIsExist", teacherIsExsit);
        modelAndView.addObject("propertyAndValue", propertyAndValue);
        return modelAndView;
    }

    private void addValueToMap(Map<String, String> propertyAndValue, Teacher_Property teacher_property) {
        List<Teacher_Property_Value> teacher_property_values = tp_valueService.get(teacher_property.getTeacher_property_id());
        StringBuilder stringBuilder = new StringBuilder();
        for (Teacher_Property_Value spv : teacher_property_values) {
            stringBuilder.append(spv.getProperty_value() + "\n");
        }
        propertyAndValue.put(teacher_property.getProperty_name(), stringBuilder.toString());

    }

    @RequestMapping("/ManagerAddTeacherPage")
    public ModelAndView managerAddTeacherPage() {
        ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerAddAndDeleteTeacher");
        boolean add = true;
        modelAndView.addObject("add", add);
        modelAndView.addObject("teacherIsExist", true);
        return modelAndView;
    }
    @RequestMapping("/ManagerDeleteTeacherPage")
    public ModelAndView managerDeleteTeacherPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteTeacher");
        boolean delete=true;
        modelAndView.addObject("delete",delete);
        modelAndView.addObject("teacherIsExist",true);
        return modelAndView;
    }

    @RequestMapping("/ManagerDeleteTeacher")
    public ModelAndView deleteTeacher(String username){
        ModelAndView modelAndView=new ModelAndView("ManagerAddAndDeleteTea" + "cher");
        Teacher teacher=teacherService.get(username);
        if(!isExsit(modelAndView,username)){
           return modelAndView;
        }
        s_tService.deleteAllByTeacher(teacher.getTeacher_id());
        List<Course> courses=courseService.getCourseByTeacher(teacher.getTeacher_id());
        //删除所有课程和属性
        for(Course course:courses){
            c_valueService.delete(course.getCourse_id());
            courseScoreService.deleteAllByCourseId(course.getCourse_id());
            courseService.deleteById(course.getCourse_id());
        }
        List<Teacher_Property>teacher_properties=t_propertyService.getAllByTeacher(teacher.getTeacher_id());
        for(Teacher_Property tp:teacher_properties){
            tp_valueService.deleteAllByproperty(tp.getTeacher_property_id());
            t_propertyService.deleteById(tp.getTeacher_property_id());
        }
        teacherService.delete(username);
        modelAndView.addObject("delete",true);
        modelAndView.addObject("success",true);
        return modelAndView;
    }

    private void addTp(Teacher teacher,String propertyName){
        Teacher_Property teacher_property=new Teacher_Property();
        teacher_property.setProperty_name(propertyName);
        teacher_property.setTeacher(teacher);
        t_propertyService.add(teacher_property);
    }

    @RequestMapping("/ManagerAddTeacher")
    public ModelAndView addStudent(String username,String password,String name){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteTeacher");
        if(isExsit(modelAndView,username)){
            modelAndView.addObject("teacherIsExist",false);
            modelAndView.addObject("add",true);
            modelAndView.addObject("countIsExist",true);
            return modelAndView;
        }
        Teacher teacher=new Teacher();
        teacher.setUsername(username);
        teacher.setPassword(password);
        teacher.setName(name);
        teacher.setRole("teacher");
        teacherService.add(teacher);
        int teacherId=teacherService.getIdByName(teacher.getName());
        teacher.setTeacher_id(teacherId);
        addTp(teacher,"basicInfo");
        addTp(teacher,"science");
        addTp(teacher,"career");
        addTp(teacher,"rewardAndPunish");
        modelAndView.addObject("add",true);
        modelAndView.addObject("addSuccess",true);
        return modelAndView;
    }

    @RequestMapping(value="/addTeacherProperty",method = RequestMethod.POST)
    public ModelAndView addTeacherProperty(TeacherPropertyUtil teacherPropertyUtil){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateTeacher");
        String username=teacherPropertyUtil.getUsername();
        if(!isExsit(modelAndView,username)){
            return modelAndView;
        }
        add(username,teacherPropertyUtil.getBasicInfo(),"basicInfo");
        add(username,teacherPropertyUtil.getCareer(),"career");
        add(username,teacherPropertyUtil.getRewardAndPunish(),"rewardAndPunish");
        add(username,teacherPropertyUtil.getScience(),"science");
        modelAndView.addObject("teacherIsExist",true);
        modelAndView.addObject("update",true);
        return modelAndView;
    }

    @RequestMapping(value = "/updateTeacherProperty",method = RequestMethod.POST)
    public ModelAndView updateStudentProperty(TeacherPropertyUtil teacherPropertyUtil) {
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateTeacher");
        String username=teacherPropertyUtil.getUsername();
        if(!isExsit(modelAndView,username)){
            return modelAndView;
        }
        //
        List<Teacher_Property>teacher_properties=t_propertyService.getAllByTeacher(teacherService.getId(username));
        for(Teacher_Property tp:teacher_properties){
            tp_valueService.deleteAllByproperty(tp.getTeacher_property_id());
        }
        //
        add(username,teacherPropertyUtil.getBasicInfo(),"basicInfo");
        add(username,teacherPropertyUtil.getCareer(),"career");
        add(username,teacherPropertyUtil.getRewardAndPunish(),"rewardAndPunish");
        add(username,teacherPropertyUtil.getScience(),"science");
        modelAndView.addObject("teacherIsExist",true);
        modelAndView.addObject("update",true);
        return modelAndView;
    }
    //
    private void add(String username,String info,String propertyName){
        if(info!=null){
            int teacher=teacherService.getId(username);
            List<Teacher_Property> teacher_properties=t_propertyService.getAllByTeacher(teacher);
            for(Teacher_Property tp:teacher_properties){
                if(tp.getProperty_name().equals(propertyName)) {
                    Teacher_Property_Value  teacher_property_value=new Teacher_Property_Value();
                    teacher_property_value.setProperty_value(info);
                    teacher_property_value.setTeacher_property(tp);
                    tp_valueService.add(teacher_property_value);
                    break;
                }
            }
        }
    }

    private boolean isExsit(ModelAndView modelAndView,String username){
       if(teacherService.get(username)==null){
           return false;
       }
       return true;
    }
    private boolean usernameIsExist(String username){
        Teacher teacher=teacherService.get(username);
        Student student=studentService.get(username);
        Manager manager=managerService.get(username);
        if(teacher==null&&student==null&&manager==null){
            return false;
        }
        return true;
    }


}
