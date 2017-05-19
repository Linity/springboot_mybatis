//package java;

import com.ljw.web.utils.MessageUtil;
import com.ljw.web.weixin.pojo.TextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Date;

/**
 * Created by Linity on 2017/4/26.
 */
public class test {

    private Integer Code;
    private String Number;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }


    public Integer getCode() {
        return Code;
    }
    public void setCode(Integer code) {
        this.Code = code;
    }

    public static void main(String[] args) {
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName("123");
        textMessage.setToUserName("123");
        textMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
        textMessage.setCreateTime(new Date().toString());
        textMessage.setContent("asd");
        textMessage.setMsgId("msg");
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        String strb = xStream.toXML(textMessage);
        System.out.println(strb);
    }

}
