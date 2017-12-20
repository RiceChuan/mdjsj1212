package com.madagascar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpSession;

/**
 * @Creator future
 * @Date 02/09/2017 2:38 PM
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:38 PM
 * @LOG $log$
 */

@Setter
@Getter
public class LoginResponse {

    @JsonProperty("sessionId")
    private String token;

    private HttpSession session;


    public LoginResponse() {
    }

    public LoginResponse(String token) {
        this.token = token;
    }
}
