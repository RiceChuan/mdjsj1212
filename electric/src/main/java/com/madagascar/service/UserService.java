package com.madagascar.service;

import com.madagascar.common.RestResult;

import javax.servlet.http.HttpSession;

/**
 * Created by RiceChuan on 17.12.11.
 */
public interface UserService {
    RestResult login(String username, String password, HttpSession session);
}
