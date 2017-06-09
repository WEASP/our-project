package com.weasp.service;

import org.springframework.stereotype.Service;

/**
 * Created by 72703 on 2017/6/8.
 */
@Service
public class ZhifouService {
    public String getMessage(int userId){
        return "Hello Message:" + String.valueOf(userId);
    }
}
