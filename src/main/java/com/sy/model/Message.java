package com.sy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LEAVE_MESSAGE")
public class Message {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String createdBy;
    private String messageContent;
    private String messageTitle;
    private String messageCode;
    private Integer state;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Message(String createdBy, String messageContent, Integer state, Date createTime) {
        this.createdBy = createdBy;
        this.messageContent = messageContent;
        this.state = state;
        this.createTime = createTime;
    }

    public Message() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", createdBy='" + createdBy + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageCode='" + messageCode + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
