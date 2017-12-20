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

    private Integer type;

    public User() {
    }
}
