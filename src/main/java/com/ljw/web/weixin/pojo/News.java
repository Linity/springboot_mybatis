package com.ljw.web.weixin.pojo;

/**
 * Created by Linity on 2017/3/6.
 */
public class News {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

}
