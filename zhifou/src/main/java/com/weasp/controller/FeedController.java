package com.weasp.controller;

import com.weasp.model.EntityType;
import com.weasp.model.Feed;
import com.weasp.model.HostHolder;
import com.weasp.service.FeedService;
import com.weasp.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JackHui on 2017/6/21.
 */
@Controller
public class FeedController {
    @Autowired
    FeedService feedService;

    @Autowired
    HostHolder hostHolder;
    @Autowired
    FollowService followService;
    @RequestMapping(path = {"/pullfeeds"},method = {RequestMethod.GET})
    private String getPullFeeds(Model model)
    {
        int localUserId=hostHolder.getUser()==null?0:hostHolder.getUser().getId();
        List<Integer> followees=new ArrayList<>(  );
        if(localUserId!=0)
        {
            followees=followService.getFollowees( localUserId, EntityType.ENTITY_USER,Integer.MAX_VALUE );
        }
List<Feed> feeds=feedService.getUserFeeds(Integer.MAX_VALUE,followees,10 );
model.addAttribute( "feeds",feeds );
        return "feeds";
    }
}
