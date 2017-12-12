package com.madagascar.controller;

import com.madagascar.common.RestResult;
import com.madagascar.dto.LoginRequest;
import com.madagascar.oauth.annotation.Authorization;
import com.madagascar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by RiceChuan on 17.12.11.
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService mUserService;

    @RequestMapping("/")
    public String login(Map map){
        map.put("key","张三yii");
        return "login";
    }

    @RequestMapping("/toWelcome")
//    @Authorization
    public String index(Map map){
        map.put("key","张三yii");
        return "index";
    }
    @PostMapping("/login")
    @ResponseBody
    public RestResult test(@RequestBody LoginRequest loginRequest, HttpSession session){
        return mUserService.login(loginRequest.getUsername(),loginRequest.getPassword(),session);
    }
}
