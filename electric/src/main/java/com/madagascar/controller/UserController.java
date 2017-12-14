package com.madagascar.controller;

import com.madagascar.common.RestResult;
import com.madagascar.dto.LoginRequest;
import com.madagascar.model.User;
import com.madagascar.oauth.annotation.Authorization;
import com.madagascar.oauth.annotation.CurrentUser;
import com.madagascar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public String login(HttpSession session){
        if(session.getAttribute("username")!=null ){
            return "index";
        }else {
            return "login";
        }
    }


    @RequestMapping("/toWelcome")
    @Authorization
    public String index(Map map){
        map.put("key","张三yii");
        return "index";
    }
    @PostMapping("/login")
    @ResponseBody
    public RestResult test(@RequestBody LoginRequest loginRequest, HttpSession session){
        return mUserService.login(loginRequest.getUsername(),loginRequest.getPassword(),session);
    }
    @PostMapping("logout")
    @ResponseBody
    @Authorization
    public RestResult<Boolean> logout(@CurrentUser User user, HttpSession session) {
//        return mUserService.logout(user,session);
        return null;
    }

}
