package com.madagascar.controller;

import com.madagascar.dto.RequestUser;
import com.madagascar.model.AppUser;
import com.madagascar.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 0 on 2017/12/13.
 * 测试用
 */
@RestController
public class AppUserControl {
    @Autowired
    AppUserService appUserService;
    //为了方便测试 这里一个接口会做所有的事情
    @PostMapping(value = "/insert_app_user",produces = "application/json;charset=UTF-8")
    public Object appUserOperate(@RequestBody RequestUser requestUser){
        String codeData = requestUser.getCode();
        AppUser appUser = new AppUser();
        if(codeData.equals("1")){
            //注册操作
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            appUser.setCreate_time(simpleDateFormat.format(new Date()));
            appUser.setUsername(requestUser.getName());
            appUser.setPassword(requestUser.getPassword());
            return appUserService.insertUser(appUser);
        }else if(codeData.equals("2")){
            //登陆操作
            appUser.setUsername(requestUser.getName());
            appUser.setPassword(requestUser.getPassword());
            return appUserService.login(appUser);
        }else if(codeData.equals("3")){
            //查询操作
           appUser.setId(requestUser.getId());
           return appUserService.query(appUser);
        }else if(codeData.equals("4")){
            //充值操作
            appUser.setId(requestUser.getId());
            appUser.setPower_account((double) Math.round(requestUser.getPower_account()*1000)/1000);
            appUser.setPower_remain((double) Math.round(requestUser.getPower_remain()*1000)/1000);
            appUser.setTotal_consumption((double) Math.round(requestUser.getTotal_consumption()*1000)/1000);
            appUser.setConsumption_balance((double)Math.round(requestUser.getConsumption_balance()*1000)/1000);
            return appUserService.recharge(appUser);
        }
        return "error";
    }
}
