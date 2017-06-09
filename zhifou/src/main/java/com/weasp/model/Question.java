package com.weasp.model;

import java.util.Date;

/**
 * Created by 72703 on 2017/6/8.
 */
public class Question{
    private int id;
    private String title;
    private String content;
    private Date createdDate;
    private int userId;
    private int commentCount;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public Date getCreateDate(){
        return createdDate;
    }
    public void setcreateDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getCommentCount(){
        return commentCount;
    }
    public void setCommentCount(int commentCount){
        this.commentCount = commentCount;
    }
}
