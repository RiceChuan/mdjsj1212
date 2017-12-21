package com.madagascar.service.impl;

import com.google.common.collect.Lists;
import com.madagascar.common.ErrorCode;
import com.madagascar.common.Properties;
import com.madagascar.common.RestResult;
import com.madagascar.dao.AppUserMapper;
import com.madagascar.dao.TokenMapper;
import com.madagascar.dao.UserMapper;
import com.madagascar.dto.LoginResponse;
import com.madagascar.model.AppUser;
import com.madagascar.model.Token;
import com.madagascar.model.User;
import com.madagascar.model.UserLogger;
import com.madagascar.service.UserService;
import com.madagascar.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RiceChuan on 17.12.11.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    AppUserMapper appUserMapper;

    @Override
    public RestResult<Boolean> logout(HttpSession session) {
        tokenMapper.deleteByUid((String) session.getAttribute("token"));
        session.invalidate();
        return RestResult.success(true);
    }

    @Override
    public Map searchUserData() {
        List<AppUser> list=appUserMapper.searchUserData();
        Map<String, Object>  map = new HashMap();
        int number = userMapper.searchUserDataNumber();
        map.put("total",number);
        map.put("rows",list);
        return map;
    }

    @Override
    public RestResult login(String username, String password, HttpSession session) {
        User user = userMapper.findByUserNameAndPwd(username, password);
        if (user != null) {

            tokenMapper.deleteByUid(user.getId());
            Token token = new Token(UUIDUtils.generateId(), user.getId());
            tokenMapper.insert(token);
            //session过期时间
            session.setMaxInactiveInterval(Properties.TIME_OVER);
            session.setAttribute("username",user.getUsername());
            session.setAttribute("token",token.getToken());

            return RestResult.success(new LoginResponse(token.getToken()));
        }
        return RestResult.info(ErrorCode.ERROR_USER_OR_PWD_WRONG);
    }
}
