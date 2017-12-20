package com.madagascar.service;

import com.madagascar.common.RestResult;
import com.madagascar.dto.LoginResponse;
import com.madagascar.model.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by RiceChuan on 17.12.11.
 */
public interface UserService {
    RestResult<LoginResponse> login(String username, String password, HttpSession session);

    Map searchUserData();

    RestResult<Boolean> logout( HttpSession session);
}
