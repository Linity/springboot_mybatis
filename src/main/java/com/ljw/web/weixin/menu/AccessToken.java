package com.ljw.web.weixin.menu;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;


/**
 * Created by Linity on 2017/3/8.
 */
public class AccessToken {
    private static final String APPID = "wxa412acc803fe6611";
    private static final String APPSECRET = "fd2f9c1249df5f8d7495890de3f6ef6a";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private String access_token;
    private Integer expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
    /**
     * 获取accessToken
     * @return
     * @throws ParseException
     * @throws IOException
     */
//    public static AccessToken getAccessToken() throws ParseException, IOException{
//        AccessToken token = new AccessToken();
//        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
//        JSONObject jsonObject = WeixinUtil.doGetStr(url);
//        if(jsonObject!=null){
//            token.setAccess_token(jsonObject.getString("access_token"));
//            token.setExpires_in(jsonObject.getIntValue("expires_in"));
//        }
//        return token;
//    }
}
