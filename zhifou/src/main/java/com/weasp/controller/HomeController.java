package com.weasp.controller;

import com.weasp.model.Question;
import com.weasp.model.ViewObject;
import com.weasp.service.QuestionService;
import com.weasp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 72703 on 2017/6/8.
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    private List<ViewObject> getQuestions(int offset, int limit){
        List<Question> questionList = questionService.getLatestQuestions(offset,limit);
        List<ViewObject>  vos = new ArrayList<ViewObject>();
        for(Question question : questionList){
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }
    private List<ViewObject> getQuestion(int userId){
        Question question = questionService.getQuestion(userId);
        List<ViewObject>  vos = new ArrayList<ViewObject>();
        ViewObject vo = new ViewObject();
        vo.set("question", question);
        vo.set("user", userService.getUser(question.getUserId()));
        vos.add(vo);

        return vos;
    }

    @RequestMapping(path = {"/a"})
    @ResponseBody
    public String home(){
        return "Hello";
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(Model model,
                        @RequestParam(value ="pop",defaultValue = "0") int pop){
        model.addAttribute("vos",getQuestions(0,10));
        return "index";
    }

    @RequestMapping(path={"/user/{userId}"})
    public String userindex(Model model,
                            @PathVariable("userId") int userId){
        model.addAttribute("vos",getQuestion(userId));
        return "index";
    }


}
