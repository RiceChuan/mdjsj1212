package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 0 on 2017/12/15.
 * app帐号信息
 */
@Getter
@Setter
@ToString
public class AppUser {
    private String id;
    private String username;
    private String password;
    //累计用电量
    private double power_account;
    //剩余电量
    private double power_remain;
    //消费总计
    private double total_consumption;
    //账户余额
    private double consumption_balance;
    //帐号注册时间
    private String create_time;
    //支付方式
    private int pay_method;
}
