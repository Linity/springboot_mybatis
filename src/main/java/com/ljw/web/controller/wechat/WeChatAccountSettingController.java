package com.ljw.web.controller.wechat;

import com.ljw.web.dao.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Linity on 2017/4/22.
 */
@Controller
@RequestMapping("/weChat")
public class WeChatAccountSettingController {
    @Autowired
    PictureMapper pictureMapper;

    @RequestMapping("/weiXinSetting")
    public String weiXinIndex(){
        return "wechat/weiXinSetting";
    }

    @RequestMapping("/accountDetail")
    public String accountDetail(ModelMap map,Long id){
//        pictureMapper.selectByUserId(id);
        map.put("url",pictureMapper.selectByUserId(id).getImagePath());
        return "wechat/accountDetail";
    }

}
