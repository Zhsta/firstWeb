package com.zhao.controller;
import com.zhao.pojo.Attention;
import com.zhao.service.AttentionService;
import com.zhao.service.ManagerService;
import com.zhao.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
public class HomePageController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private AttentionService attentionService;
    @RequestMapping("/homePageAttention/{start}")
    public ModelAndView attention(@PathVariable("start")int start){
        Page page=null;
        List<Attention> attentions=null;
        ModelAndView modelAndView=new ModelAndView();
            page=new Page();
            attentions=attentionService.listAll();
            modelAndView.addObject("importantMessage",attentions);
            page.setTotal(attentions.size());
            page.init();
            page.setStart(start);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("mainJsp/StudentHomePageAttention");
        return modelAndView;
    }
    @RequestMapping("/homePageQuickEntry")
    public ModelAndView qe(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentHomePageQuickEntry");
        return  modelAndView;
    }
    @RequestMapping("/homePage")
    public ModelAndView homePage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/StudentHomePage");
        return modelAndView;
    }

    @RequestMapping("/logOff")
    public ModelAndView logOff(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("mainJsp/welcome");
        session.removeAttribute("user");
        return modelAndView;
    }



}
