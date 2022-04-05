package com.instantmessagetool.qqserver.common;

import java.io.Serializable;

/**
 * @author pi
 * @date 2021/05/16 18:01:41
 * //表示客户端与服务端通讯的消息
 **/
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sender;
    private String receiver;
    private String content;
    private String senderTime;
    private String messageType;

    public Message(String sender, String receiver, String content, String senderTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.senderTime = senderTime;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderTime() {
        return senderTime;
    }

    public void setSenderTime(String senderTime) {
        this.senderTime = senderTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
