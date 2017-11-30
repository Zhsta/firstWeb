package com.zhao.controller;

import com.zhao.pojo.Student_Property;
import com.zhao.pojo.Student_Property_Value;
import com.zhao.service.SP_ValueService;
import com.zhao.service.StudentService;
import com.zhao.service.Student_PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class PersonManage {
    @Autowired
    private Student_PropertyService student_propertyService;
    @Autowired
    private StudentService studentServices;
    @Autowired
    private SP_ValueService sp_valueService;
    @RequestMapping("/PersonManage")
    public ModelAndView personManage(String username, String name){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentPersonManage");
        Map<String,String> propertyAndValue=new HashMap<>();
        List<Student_Property> student_properties=student_propertyService.get(studentServices.getId(username));
        for(Student_Property student_property:student_properties){
                addValueToMap(propertyAndValue,student_property);
        }
        modelAndView.addObject("name",name);
        modelAndView.addObject("propertyAndValue",propertyAndValue);
        return modelAndView;
    }

    public void addValueToMap(Map<String,String>propertyAndValue,Student_Property student_property ){
        List<Student_Property_Value>student_property_values=sp_valueService.get(student_property.getProperty_id());
        StringBuilder stringBuilder=new StringBuilder();
        for(Student_Property_Value spv:student_property_values){
            stringBuilder.append(spv.getValue()+"\n");
        }
        propertyAndValue.put(student_property.getProperty_name(),stringBuilder.toString());
    }

}
