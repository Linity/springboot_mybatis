package com.ljw.web.utils;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

import com.ljw.web.weixin.pojo.News;
import com.ljw.web.weixin.pojo.NewsMessage;
import com.ljw.web.weixin.pojo.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by Linity on 2017/3/4.
 */
public class MessageUtil {

//    private static Logger logger = LoggerFactory.getLogger(MessageUtil.class);
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "click";
    public static final String MESSAGE_VIEW = "view";
    public static final String MESSAGE_NEWS = "news";

    public static Map<String,String> xmlToMap(HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try ( InputStream ins = request.getInputStream() ){
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            map = list.stream().collect(Collectors.toMap(Element::getName,Element::getText));
        } catch (IOException e) {
//            logger.error(e.getMessage(),"InputStream");
            e.printStackTrace();
        } catch (DocumentException e) {
//            logger.error(e.getMessage(),"Document");
            e.printStackTrace();
        }
        return map;
    }

    public static String testMessageToXml(TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().toString());
        textMessage.setContent(content);
        return testMessageToXml(textMessage);
    }

    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
        sb.append("1.");
        sb.append("2.");
        sb.append("回复?调出此菜单。");
        return sb.toString();
    }

    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("1.");
        return sb.toString();
    }

    public static String secondMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("2.");
        return sb.toString();
    }

    /**
     * 图文消息转为xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",newsMessage.getClass());
        xStream.alias("item",new News().getClass());
        return xStream.toXML(newsMessage);
    }

    /**
     * 组装图文消息
     * @param toUserName
     * @param fromUserName
     * @return
     */
    public static String initNewsMessage(String toUserName,String fromUserName){
        String message = null;
        List<News> news = new ArrayList<>();
        NewsMessage newsMessage = new NewsMessage();
        News news1 = new News();
        news1.setTitle("微信公众号");
        news1.setDescription("这是我的个人公众号");
        news1.setPicUrl("http://curry.tunnel.qydev.com/images/pic91.jpg");
        news1.setUrl("http://curry.tunnel.qydev.com/pages/login.html");
        news.add(news1);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().toString());
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticleCount(news.size());
        newsMessage.setArticles(news);
        message = newsMessageToXml(newsMessage);
        return message;
    }
}
