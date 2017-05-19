package com.ljw.web.weixin.pojo;

/**
 * Created by Linity on 2017/3/4.
 */
public class TextMessage extends BaseMessage{
    private String Content;
    private String MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }


}
