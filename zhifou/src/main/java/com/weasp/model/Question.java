package com.weasp.model;

import java.util.Date;

/**
 * Created by 72703 on 2017/6/8.
 */
public class Question{
    private int id;
    private String title;
    private String content;
    private Date createDate;
    private int userId;
    private String commentCount;

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
        return createDate;
    }
    public void setcreateDate(Date createDate){
        this.createDate = createDate;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getCommentCount(){
        return commentCount;
    }
    public void setcommentCount(String commentCount){
        this.commentCount = commentCount;
    }
}
