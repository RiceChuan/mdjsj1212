package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 0 on 2017/12/19.
 * 用户日用电表
 */
@Getter
@Setter
@ToString
public class Energy {
    private String id;
    private String  user_id;
    private double use_power;
    private String use_date;
}
