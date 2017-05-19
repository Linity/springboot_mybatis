package com.ljw.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljw.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.ljw.web.config.WebSecurityConfig.SESSION_KEY;

/**
 * Created by Linity on 2017/4/29.
 */
@Controller
@RequestMapping("/fileServer")
public class FileController {

    private UserService userService;

    @Autowired
    public FileController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject fileUpload3(@RequestParam("file") MultipartFile file, HttpSession session, HttpServletRequest req){
        System.out.println("fileName：" + file.getOriginalFilename());
        JSONObject object = new JSONObject();
        if(!file.isEmpty() && session.getAttribute(SESSION_KEY) != null) {
            String fileName = new Date().getTime() + file.getOriginalFilename();
            //获取输出流
            try (BufferedOutputStream stream = new
                    BufferedOutputStream(new FileOutputStream(new File("F:/pic-server/pic/" + fileName)))) {
                byte[] bytes = file.getBytes();
                stream.write(bytes);
                stream.close();
                return userService.savePicture((String)session.getAttribute(SESSION_KEY),fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return object;
            } catch (IOException e) {
                e.printStackTrace();
                return object;
            }
        }else{
            return object;
        }
    }
}
