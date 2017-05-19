package com.ljw.web.controller;

import com.ljw.web.utils.CheckUtil;
import com.ljw.web.utils.MessageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Linity on 2017/4/26.
 */
@Controller
public class WeiXinController {

    @RequestMapping(value = "/weixin",method = {RequestMethod.GET})
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = resp.getWriter();
        if(CheckUtil.checkSignature(signature,timestamp,nonce)){
            out.print(echostr);//如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
        }
        out.close();
    }
    /**
     * 微信消息的处理
     *
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/weixin",method = { RequestMethod.POST })
    public void dispose(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* 消息的接收、处理、响应 */
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Map<String,String> map = MessageUtil.xmlToMap(request);
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String msgType = map.get("MsgType");
        String content = map.get("Content");
        String message=null;
        if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
            if("1".equals(content)){
                message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.firstMenu());
            }else if("2".equals(content)){
//                message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.secondMenu());
                message = MessageUtil.initNewsMessage(toUserName,fromUserName);
            }else if("?".equals(content) || "？".equals(content)){
                message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.menuText());
            }
        }else if (MessageUtil.MESSAGE_EVENT.equals(msgType)){
            String eventType = map.get("Event");
            if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
                message = MessageUtil.initText(toUserName,fromUserName,MessageUtil.menuText());
            }
        }
        System.out.println(message);
        out.print(message);
        out.close();
    }
}
