package com.zhao.controller;
import com.zhao.pojo.Manager;
import com.zhao.pojo.Student;
import com.zhao.pojo.Student_Property;
import com.zhao.pojo.Student_Property_Value;
import com.zhao.pojo.Teacher;
import com.zhao.service.CourseScoreService;
import com.zhao.service.ManagerService;
import com.zhao.service.SP_ValueService;
import com.zhao.service.S_CService;
import com.zhao.service.S_TService;
import com.zhao.service.StudentService;
import com.zhao.service.Student_PropertyService;
import com.zhao.service.TeacherService;
import com.zhao.util.StudentPropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerStudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseScoreService courseScoreService;
    @Autowired
    private S_TService s_tService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private S_CService s_cService;
    @Autowired
    private Student_PropertyService student_propertyService;
    @Autowired
    private SP_ValueService sp_valueService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/StudentSearchPage")
    public ModelAndView studentSearchPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerStudentControl");
        modelAndView.addObject("checked",false);
        modelAndView.addObject("studentIsExist",true);
        return modelAndView;
    }
    @RequestMapping("/ManagerAddStudentPage")
    public ModelAndView managerAddStudentPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteStudent");
        boolean add=true;
        modelAndView.addObject("add",add);
        modelAndView.addObject("studentIsExist",true);
        return modelAndView;
    }

    @RequestMapping("/ManagerDeleteStudentPage")
    public ModelAndView managerDeleteStudentPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteStudent");
        modelAndView.addObject("delete",true);
        return modelAndView;
    }
    @RequestMapping("/updateStudent")
    public ModelAndView updateStudentPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateStudent");
        modelAndView.addObject("studentIsExist",true);
        return modelAndView;
    }

    @RequestMapping("StudentSearch")
    public ModelAndView studentSearch(String username){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerStudentControl");
        if(!isExsit(modelAndView,username)){
            return  modelAndView;
        }
        Map<String,String> propertyAndValue=new HashMap<>();
        List<Student_Property> student_properties=student_propertyService.get(
                                              studentService.getId(username) );
        for(Student_Property student_property:student_properties){
            addValueToMap(propertyAndValue,student_property);
        }
        modelAndView.addObject("checked",true);
        modelAndView.addObject("studentIsExist",true);
        modelAndView.addObject("propertyAndValue",propertyAndValue);
        return  modelAndView;
    }

    private void addValueToMap(Map<String,String>propertyAndValue,Student_Property student_property ){
        List<Student_Property_Value>student_property_values=sp_valueService.get(
                                              student_property.getProperty_id() );
        StringBuilder stringBuilder=new StringBuilder();
        for(Student_Property_Value spv:student_property_values){
            stringBuilder.append(spv.getValue()+"\n");
        }
        propertyAndValue.put(student_property.getProperty_name(),stringBuilder.toString());
    }


    //为student添加名为propertyName的属性值
    private void addSP(Student student,String propertyName){
        Student_Property student_property=new Student_Property();
        student_property.setProperty_name(propertyName);
        student_property.setStudent(student);
        student_propertyService.add(student_property);
    }

    @RequestMapping("/ManagerAddStudent")
    public ModelAndView addStudent(String username,String password,String name){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteStudent");
        if(usernameIsExist(username)){
            modelAndView.addObject("add",true);
            return modelAndView;
        }
        Student student=new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setName(name);
        //得到添加后的id值
        studentService.add(student);
        student.setStudent_id(studentService.getId(username));
        //添加这五种属性
        addSP(student,"basicInfo");
        addSP(student,"schoolrool");
        addSP(student,"rewardAndPunish");
        addSP(student,"minor");
        addSP(student,"schoolRoolChange");

        modelAndView.addObject("success",true);
        modelAndView.addObject("studentIsExist",true);
        modelAndView.addObject("add",true);
        return modelAndView;
    }

    @RequestMapping("/ManagerDeleteStudent")
    public ModelAndView deleteStduent(String username){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerAddAndDeleteStudent");
        Student student=studentService.get(username);

        if(!isExsit(modelAndView,username)){
            modelAndView.addObject("delete",true);
            return modelAndView;
        }
        //在student-course 和 student-teacher表中删除
        s_cService.deleteAllByStudent(student.getStudent_id());
        s_tService.deleteAllByStudent(student.getStudent_id());
        // 删除属性值
        List<Student_Property>student_properties=student_propertyService.get( student.getStudent_id() );
        for(Student_Property sp:student_properties){
            sp_valueService.delete(sp.getProperty_id());
        }
        //删除属性
        student_propertyService.deleteAll(student.getStudent_id());
        courseScoreService.deleteAllByStudentId(student.getStudent_id());
        //删除学生
        studentService.delete(student.getStudent_id());

        modelAndView.addObject("delete",true);
        modelAndView.addObject("success",true);
        return modelAndView;
    }

    @RequestMapping(value="/addStudentProperty",method = RequestMethod.POST)
    public ModelAndView addStudentProperty( StudentPropertyUtil studentPropertyUtil){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateStudent");
        String username=studentPropertyUtil.getUsername();
        if(!isExsit(modelAndView,username)){
            modelAndView.addObject("studentIsExist",true);
           return modelAndView;
        }
        //得到用户的所有属性列表
        int student=studentService.getId(username);
        List<Student_Property> student_property=student_propertyService.get(student);
        //将get得到的值加入到与propertyName对应的property中
        add(student_property,studentPropertyUtil.getBasicInfo(),"basicInfo");
        add(student_property,studentPropertyUtil.getMinor(),"minor");
        add(student_property,studentPropertyUtil.getRewardAndPunish(),"rewardAndPunish");
        add(student_property,studentPropertyUtil.getSchoolrool(),"schoolrool");
        add(student_property,studentPropertyUtil.getSchoolRoolChange(),"schoolRoolChange");
        modelAndView.addObject("studentIsExist",true);
        modelAndView.addObject("countIsExist",false);
        modelAndView.addObject("success",true);
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudentProperty",method = RequestMethod.POST)
    public ModelAndView updateStudentProperty(StudentPropertyUtil studentPropertyUtil) {
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateStudent");
        String username=studentPropertyUtil.getUsername();
        if(!isExsit(modelAndView,username)){
            return modelAndView;
        }
        //删除相应属性的所有值
        int student=studentService.getId(username);
        List<Student_Property> student_property=student_propertyService.get(student);
        List<String> propertyNames=new ArrayList<>();
        for(Student_Property sp:student_property){
            propertyNames.add(sp.getProperty_name());
            sp_valueService.delete(sp.getProperty_id());
        }
        //添加属性
        add(student_property,studentPropertyUtil.getBasicInfo(),"basicInfo");
        add(student_property,studentPropertyUtil.getMinor(),"minor");
        add(student_property,studentPropertyUtil.getRewardAndPunish(),"rewardAndPunish");
        add(student_property,studentPropertyUtil.getSchoolrool(),"schoolrool");
        add(student_property,studentPropertyUtil.getSchoolRoolChange()," schoolRoolChange");
        modelAndView.addObject("studentIsExist",true);
        modelAndView.addObject("success",true);
        return modelAndView;
    }
    //将info添加进stduentProperty中的属性名为propertyName的属性值中
    private void add(List<Student_Property> student_property,String info,String propertyName){
        if(info!=""){
            for(Student_Property sp:student_property){
                if(sp.getProperty_name().equals(propertyName)) {
                    Student_Property_Value student_property_value=new Student_Property_Value();
                    student_property_value.setValue(info);
                    student_property_value.setStudent_property(sp);
                    sp_valueService.add(student_property_value);
                    break;
                }
            }
        }
    }
    //判断账户是否存在
    private boolean isExsit(ModelAndView modelAndView,String username){
        Student student=studentService.get(username);
        if(student==null){
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


