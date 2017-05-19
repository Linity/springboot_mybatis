package com.ljw.web.service;

import com.alibaba.fastjson.JSONObject;
import com.ljw.web.dao.PictureMapper;
import com.ljw.web.dao.UserMapper;
import com.ljw.web.entity.Picture;
import com.ljw.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
@Service
public class UserService {
    private UserMapper userMapper;
    private PictureMapper pictureMapper;
    @Autowired
    public UserService(UserMapper userMapper,PictureMapper pictureMapper){
        this.userMapper = userMapper;
        this.pictureMapper = pictureMapper;
    }

    @Cacheable(value="user-key")
    public String getUserById(Long id){
        return userMapper.selectByPrimaryKey(id).getName();
    }

    public Boolean checkUser(User userEntity){
        User user = userMapper.selectByName(userEntity.getName());
        if (user == null) {
            return false;
        }
        if(userEntity.getPassword().equals(user.getPassword())){
            userEntity.setId(user.getId());
            return true;
        }
        return false;
    }

    public JSONObject savePicture(String userName, String fileName){
        JSONObject object = new JSONObject();
        User user = userMapper.selectByName(userName);
        Picture picture = pictureMapper.selectByUserId(user.getId());
        if(picture != null){
            picture.setImageName(fileName);
            picture.setImagePath("/pic/"+fileName);
            picture.setUploadTime(new Date());
            pictureMapper.updateByPrimaryKey(picture);
            object.put("id",picture.getId());
            object.put("path",picture.getImagePath());
        }else {
            Picture newPicture = new Picture();
            newPicture.setImageName(fileName);
            newPicture.setUserId(user.getId());
            newPicture.setImagePath("/pic/" + fileName);
            newPicture.setUploadTime(new Date());
            pictureMapper.insert(picture);
            object.put("id",newPicture.getId());
            object.put("path",newPicture.getImagePath());
        }
        return object;
    }
}
