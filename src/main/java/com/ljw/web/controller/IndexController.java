package com.ljw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/7 0007.
 */
@Controller
@RequestMapping("")
public class IndexController {
//,method = RequestMethod.POST
    @RequestMapping(value = "/index")
    public String index(ModelMap map, HttpSession session){
        map.put("id",session.getAttribute("user_Id"));
        return "index";
    }
}
