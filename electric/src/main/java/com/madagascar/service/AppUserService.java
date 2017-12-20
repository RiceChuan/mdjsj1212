package com.madagascar.service;

import com.madagascar.model.AppUser;

/**
 * Created by 0 on 2017/12/15.
 */
public interface AppUserService {
    String insertUser(AppUser appUser);
    String login(AppUser appUser);
    Object query(AppUser appUser);
    String recharge(AppUser appUser);
}
