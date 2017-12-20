package com.madagascar.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 0 on 2017/12/19.
 */
@Getter
@Setter
@ToString
public class EnergyRequest {
    private String id;
    private String  user_id;
    private double use_power;
    private String use_date;
    private String code;//用于判断操作的字段 1 插入 2 更新 3 查询
}
