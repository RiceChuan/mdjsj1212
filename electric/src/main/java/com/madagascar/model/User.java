package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Creator future
 * @Date 02/09/2017 3:00 PM
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 3:00 PM
 * @LOG $log$
 */
@Setter
@Getter
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String registerTime;
    private Integer type;

    public User() {
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterTime() {
        //2017-10-18 09:17:24.0原来格式，需要去掉最后 .0
        //处理后的时间格式2017-10-18 09:17:24
        String replace = registerTime.replace(".0", "");
        return replace;
    }

}
