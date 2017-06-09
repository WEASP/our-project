package com.weasp.model;

/**
 * Created by 72703 on 2017/6/8.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;

    public User(){

    }
    public User(String name){
        this.name = name;
        this.password = "";
        this.salt = "";
        this.headUrl = "";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getSalt(){
        return salt;
    }
    public void setSalt(String salt){
        this.name = salt;
    }
    public String getHeadUrl(){
        return headUrl;
    }
    public void setHeadUrl(String headUrl){
        this.headUrl = headUrl;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
