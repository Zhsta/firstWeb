package com.zhao.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ManagerController {
    @RequestMapping("/ManagerPage")
    public ModelAndView managerPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentManagerPage");
        return modelAndView;
    }

    @RequestMapping("/ManagerStudentPage")
    public ModelAndView managerStudentPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerStudentControl");
        return modelAndView;
    }
}
