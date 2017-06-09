package com.weasp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 72703 on 2017/6/8.
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /*@Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    /*private List<ViewObject> getQuestions(int userId, int offset, int limit){
        List<Question> questionList = questionService.getLatestQuestions(userId,offset,limit);
        List<ViewObject>  vos = new ArrayList<ViewObject>();
        for(Question question : questionList){
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }*/

    @RequestMapping(path = {"/a"})
    @ResponseBody
    public String home(){
        return "Hello";
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(HttpSession httpSession){
        return "index";
    }
    @RequestMapping(path = {"/b"})
    public String home(HttpSession httpSession){
        return "home";
    }
    /*public String index(Model model,
                        @RequestParam(value = "pop", defaultValue = "0") int pop){
        model.addAttribute("vos",getQuestions(0,0,10));
        return "index";
    }*/

    /*@RequestMapping(path = {"/user/{userId}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId){
        model.addAttribute("vos",getQuestions(userId,0,10));
        return "index";
    }*/

}
