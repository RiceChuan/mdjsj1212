package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by RiceChuan on 17.9.21.
 */
@Setter
@Getter
public class UserLogger {

    //日志描述
    private String log_describe;
    //操作时间
    private  String log_time;

    public UserLogger( String log_describe, String log_time) {
        this.log_describe = log_describe;
        this.log_time = log_time;
    }

    public UserLogger() {
    }

}
