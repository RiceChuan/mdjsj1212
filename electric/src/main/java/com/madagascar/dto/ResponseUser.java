package com.madagascar.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 0 on 2017/12/15.
 */
@Setter
@Getter
public class ResponseUser {
    private String name;
    private String password;
    //累计用电量
    private double power_account;
    //剩余电量
    private double power_remain;
    //消费总计
    private double total_consumption;
    //账户余额
    private String consumption_balance;
    //帐号注册时间
    private String create_time;
    //支付方式
    private String pay_method;
}
