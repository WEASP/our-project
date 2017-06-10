package com.weasp.model;

import org.springframework.stereotype.Component;

/**
 * Created by 72703 on 2017/6/10.
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser(){
        return users.get();
    }
    public void setUsers(User user){
        users.set(user);
    }
    public void clear(){
        users.remove();
    }

}
