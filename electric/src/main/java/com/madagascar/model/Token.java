package com.madagascar.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Creator future
 * @Date 02/09/2017 2:51 PM
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:51 PM
 * @LOG $log$
 */
@Setter
@Getter
public class Token {
    private String uid;
    private String token;

    public Token() {
    }

    public Token(String token, String uid) {
        this.token = token;
        this.uid = uid;
    }
}
