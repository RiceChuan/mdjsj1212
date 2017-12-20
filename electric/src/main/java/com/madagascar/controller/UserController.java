package com.madagascar.controller;

import com.madagascar.common.Properties;
import com.madagascar.common.RestResult;
import com.madagascar.dao.TokenMapper;
import com.madagascar.dto.LoginRequest;
import com.madagascar.dto.LoginResponse;
import com.madagascar.execption.AuthFailedException;
import com.madagascar.model.Token;
import com.madagascar.model.User;
import com.madagascar.oauth.annotation.Authorization;
import com.madagascar.oauth.annotation.CurrentUser;
import com.madagascar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private TokenMapper mTokenMapper;

    @RequestMapping("/")
    public String login(HttpSession session){
        String authorization = (String)session.getAttribute("token");
        //判断是否登录
        if(authorization!=null ){
            Token token = mTokenMapper.findByToken(authorization);
            //判断是否被挤掉或者过期
            if (token != null && StringUtils.isNotBlank(token.getToken())) {
                return "index";
            } else {
                return "login";
            }
        }else {
            return "login";
        }
    }


    @RequestMapping("/index")
    @Authorization
    public String index(Map map){
        map.put("key","张三yii");
        return "index";
    }
    @PostMapping("/login")
    @ResponseBody
    public RestResult<LoginResponse> test(@RequestBody LoginRequest loginRequest, HttpSession session){
        return mUserService.login(loginRequest.getUsername(),loginRequest.getPassword(),session);
    }
    @PostMapping("/logout")
    @ResponseBody
    @Authorization
    public RestResult<Boolean> logout( HttpSession session) {
        return mUserService.logout(session);
    }
    @GetMapping("/usermanage")
    @Authorization
    public String usermanage() {
        return "usermanage";
    }


    @GetMapping("/searchLogger")
    @ResponseBody
    @Authorization
    public Map searchLogger() {
        return mUserService.searchUserData();
    }

}
