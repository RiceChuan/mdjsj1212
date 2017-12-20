package com.madagascar.service.impl;

import com.google.gson.Gson;
import com.madagascar.dao.AppUserMapper;
import com.madagascar.model.AppUser;
import com.madagascar.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 0 on 2017/12/15.
 */
@Component
public class AppUserServiceImp implements AppUserService{
    @Autowired
    AppUserMapper appUserMapper;
    @Override
    public String insertUser(AppUser appUser) {
        try {
            appUserMapper.insertUser(appUser);
            return "success";
        }catch (Exception e){
            System.out.print("失败");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String login(AppUser appUser) {
        List<AppUser> listUser = appUserMapper.queryAll();
        if(listUser.size()>0){
            for (AppUser appUser1: listUser) {
                if(appUser.getUsername().equals(appUser1.getUsername())){
                    if(appUser.getPassword().equals(appUser1.getPassword())){
                        //登陆成功 返回ID
                        return appUser1.getId();//登陆成功
                    }
                    return "exit_name_but_pass_correct";//账号存在但是密码不正确
                }
            }
        }
        return "error";//帐号不存在
    }

    @Override
    public Object query(AppUser appUser) {//查询账户信息
        AppUser appUser1 = appUserMapper.query(appUser);
        //实例化Gson对象
        Gson gson = new Gson();
        //把对象转换为json对象。
        String toJson = gson.toJson(appUser1);
        System.out.println("转换后的json字符串"+toJson);
        //1、使用JSONObject
//        JSONObject json = JSONObject.fromObject(stu);
//        //2、使用JSONArray
//        JSONArray array=JSONArray.fromObject(stu);
//
//        String strJson=json.toString();
//        String strArray=array.toString();
        return toJson;
    }

    @Override
    public String recharge(AppUser appUser) {
        try {
            appUserMapper.recharge(appUser);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
