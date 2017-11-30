package com.zhao.controller;
import com.zhao.pojo.BlackList;
import com.zhao.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerBlackListController {
    @Autowired
    private BlackListService blackListService;

    @RequestMapping("blackListSearchPage")
    public ModelAndView searchPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerBlackListSearch");
        modelAndView.addObject("checked",false);
        modelAndView.addObject("notInBlackList",false);
        return modelAndView;
    }

   @RequestMapping("/blackListSearch")
    public ModelAndView search(String username) {
       ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerBlackListSearch");
       BlackList blackList = blackListService.get(username);
       if (blackList == null) {
           modelAndView.addObject("notInBlackList", true);
           return modelAndView;
       }
       modelAndView.addObject("checked",true);
       modelAndView.addObject("notInBlackList", false);
       modelAndView.addObject("blackList",blackList);
       return modelAndView;
   }

   @RequestMapping("/blackListAddPage")
   public ModelAndView blackListAddPage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerBlackListAdd");
        modelAndView.addObject("listIsExist",false);
        return modelAndView;
    }

   @RequestMapping("/blackListAdd")
    public ModelAndView blackListAdd(BlackList blackList) {
       ModelAndView modelAndView = new ModelAndView("mainJsp/ManagerBlackListAdd");
       if (blackListService.get( blackList.getUsername() ) != null) {
           modelAndView.addObject("listIsExist", true);
           return modelAndView;
       } else {
           blackListService.add(blackList);
           modelAndView.addObject("listIsExist",false);
           return modelAndView;
       }
   }

   @RequestMapping("/blackListDeletePage")
   public ModelAndView blackListDeletePage(){
       ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerBlackListDelete");
       modelAndView.addObject("listIsExist",true);
       return modelAndView;
   }

   @RequestMapping("/blackListDelete")
    public ModelAndView blackListDelete(String username){
       ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerBlackListDelete");
       if(blackListService.get(username)==null){
           modelAndView.addObject("listIsExist",false);
           return modelAndView;
       }
       else {
           modelAndView.addObject("listIsExist",true);
           blackListService.delete(username);
           return modelAndView;
       }
   }
   @RequestMapping("/updateBlackListPage")
   public ModelAndView updatePage(){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateCourse");
        modelAndView.addObject("listIsExist",true);
        return modelAndView;
   }


   @RequestMapping("/updateBlackList")
    public ModelAndView updateBlackList(String username,String reason){
        ModelAndView modelAndView=new ModelAndView("mainJsp/ManagerUpdateCourse");
        BlackList blackList=blackListService.get(username);
        if(blackList==null){
            modelAndView.addObject("listIsExist",false);
            return modelAndView;
        }
        else {
            blackList.setReason(reason);
            blackListService.update(blackList);
            modelAndView.addObject("listIsExist",true);
            return modelAndView;
        }
   }

}
