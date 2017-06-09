package com.weasp.controller;

import com.weasp.service.ZhifouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 72703 on 2017/6/8.
 */
@Controller
public class SettingController {
    @Autowired
    ZhifouService zhifouService;

    @RequestMapping(path = {"/setting"}, method = {RequestMethod.GET})
    @ResponseBody
    public String setting(HttpSession httpSession){
        return "Setting OK. " + zhifouService.getMessage(1);
    }
}
