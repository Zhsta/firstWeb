package com.zhao.controller;


import com.zhao.pojo.Manager;
import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;
import com.zhao.service.BlackListService;
import com.zhao.service.ManagerService;
import com.zhao.service.StudentService;
import com.zhao.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

@Controller
public class WelComeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BlackListService blackListService;
    @RequestMapping("/welcomePage")
    public ModelAndView welcomPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/welcome");
        return modelAndView;
    }
    @RequestMapping(value = "/welcome",method = RequestMethod.POST)
    public ModelAndView welcomeCheck(String userName, String password, HttpSession httpSession){
        ModelAndView modelAndView=new ModelAndView();
        if(blackListService.get(userName)==null) {
            if (studentService.isRegist(userName, password)) {
                Student student = studentService.get(userName);
                httpSession.setAttribute("user", student);
                modelAndView.setViewName("mainJsp/StudentHomePage");
            } else if (managerService.isRegist(userName, password)) {
                Manager manager = managerService.get(userName);
                httpSession.setAttribute("user", manager);
                modelAndView.setViewName("redirect:/ManagerPage");
            } else if (teacherService.isRegist(userName, password)) {
                Teacher teacher = teacherService.get(userName);
                httpSession.setAttribute("user", teacher);
                modelAndView.setViewName
                        ("redirect:/TeacherManage?username=" + teacher.getUsername() + "&name=" + teacher.getName());
            } else {
                int error = 0;
                modelAndView.addObject("errorMessage", error);
                modelAndView.setViewName("mainJsp/welcome");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/registerPage")
    public ModelAndView registerPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("mainJsp/register");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(String username,String password,String name,String[]role){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("mainJsp/welcome");
        //获取注册的对象类的名字
        String className=null;
        for (String s : role) {
            if (s != null) {
                className = s;
            }
        }
        String userClass = "com.zhao.pojo." + className;
            try {
                //通过反射动态的创建相应的学生 教师 管理员对象
                Class c = Class.forName(userClass);
                Object pojoClass = c.newInstance();
                Method setUsername = c.getMethod("setUsername", String.class);
                Method setPassword = c.getMethod("setPassword", String.class);
                Method setRole = c.getMethod("setRole", String.class);
                Method setName = c.getMethod("setName", String.class);
                setPassword.invoke(pojoClass, password);
                setUsername.invoke(pojoClass, username);
                setRole.invoke(pojoClass, className);
                setName.invoke(pojoClass, name);
                if(className.equals("Teacher")&&teacherService.getIdByName(username)==-1){
                       teacherService.add((Teacher) pojoClass);
                }else if(className.equals("Student")&&studentService.getId(username)==-1){
                        studentService.add((Student)pojoClass);
                }else if(className.equals("Manager")&&managerService.getId(username)==-1){
                         managerService.add((Manager)pojoClass);
                }
                else {
                    String isUserExsist="the username is registered ,please use another one";
                    modelAndView.addObject("userExsist",isUserExsist);
                    modelAndView.setViewName("mainJsp/register");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                String msg=e.getTargetException().getMessage();
                System.out.println(msg);
                e.printStackTrace();
            }

        return modelAndView;
    }

}