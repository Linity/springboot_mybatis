package com.ljw.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljw.web.entity.User;
import com.ljw.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import static com.ljw.web.config.WebSecurityConfig.SESSION_KEY;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
@Controller
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap map){
        User user = new User();
        map.put("user",user);
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public JSONObject doLogin(HttpSession session, User user){
        logger.info("ceshiceshi");
        JSONObject object = new JSONObject();
        if(userService.checkUser(user)){
            session.setAttribute(SESSION_KEY, user.getName());
            session.setAttribute("user_Id", user.getId());
            object.put("status","success");
            object.put("id",user.getId());
            return object;
        }else{
            object.put("status","fail");
            return object;
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(SESSION_KEY);
        return "success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return userService.getUserById(1l);
    }
}
