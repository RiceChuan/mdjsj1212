package com.madagascar.dao;

import com.madagascar.model.AppUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 0 on 2017/12/15.
 */
@Mapper
public interface AppUserMapper {
    //新增用户
    void insertUser(AppUser appUser);
    //查询用户相关信息
    AppUser query(AppUser appUser);
    //充值业务
    void recharge(AppUser appUser);
    //查询所有用户
    List<AppUser> queryAll();

}
