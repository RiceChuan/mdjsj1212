package com.madagascar.service.impl;

import com.madagascar.common.ErrorCode;
import com.madagascar.common.Properties;
import com.madagascar.common.RestResult;
import com.madagascar.dao.TokenMapper;
import com.madagascar.dao.UserMapper;
import com.madagascar.model.Token;
import com.madagascar.model.User;
import com.madagascar.service.UserService;
import com.madagascar.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by RiceChuan on 17.12.11.
 */
@Component
public class UserServiceImpl implements UserService {
   @Autowired
    UserMapper userMapper;
   @Autowired
    TokenMapper tokenMapper;
    @Override
    public RestResult login(String username, String password, HttpSession session) {
        User user = userMapper.findByUserNameAndPwd(username, password);
        if (user != null) {
            session.setAttribute("username",user.getUsername());
            session.setAttribute("usertype",user.getType());
            session.setAttribute("userId",user.getId());
            tokenMapper.deleteByUid(user.getId());
            Token token = new Token(UUIDUtils.generateId(), user.getId());
            tokenMapper.insert(token);
            //session过期时间
            session.setMaxInactiveInterval(Properties.TIME_OVER);

            return RestResult.success(token.getToken());
        }
        return RestResult.info(ErrorCode.ERROR_USER_OR_PWD_WRONG);
    }
}
