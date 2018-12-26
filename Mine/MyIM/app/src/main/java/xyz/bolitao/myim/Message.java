package xyz.bolitao.myim;

import java.util.Date;

public class Message {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;

    private String messageContent;
    private int type;
    private Date time;
    private String sendOutPerson;
    private String sendToMePerson;

    public Message(String messageContent, int type, Date time) {
        this.messageContent = messageContent;
        this.type = type;
        this.time = time;
    }

    public Message(String messageContent, int type, Date time, String sendOutPerson, String sendToMePerson) {
        this.messageContent = messageContent;
        this.type = type;
        this.time = time;
        this.sendOutPerson = sendOutPerson;
        this.sendToMePerson = sendToMePerson;
    }

    public static int getTypeReceived() {
        return TYPE_RECEIVED;
    }

    public static int getTypeSend() {
        return TYPE_SEND;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSendOutPerson() {
        return sendOutPerson;
    }

    public void setSendOutPerson(String sendOutPerson) {
        this.sendOutPerson = sendOutPerson;
    }

    public String getSendToMePerson() {
        return sendToMePerson;
    }

    public void setSendToMePerson(String sendToMePerson) {
        this.sendToMePerson = sendToMePerson;
    }
}
