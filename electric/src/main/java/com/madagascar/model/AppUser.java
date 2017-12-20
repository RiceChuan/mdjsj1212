package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by RiceChuan on 17.12.18.
 * 普通用户表
 */
@Setter
@Getter
public class AppUser {
    //用户id自增涨
    private int id;
    //用户名
    private String name;
    //密码
    private String password;
    //累计用电量
    private Double power_account;
    //剩余电量
    private Double power_remain;
    //总计消费
    private Double total_consumption;
    //账户余额
    private Double consumption_balance;
    //账号注册时间
    private String create_time;
    //支付方式 1银行 2手机余额
    private String pay_method;
}
