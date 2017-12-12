package com.madagascar.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by RiceChuan on 17.12.12.
 */

@Setter
@Getter
@ToString
public class LoginRequest {

    private String username;

    private String password;
}
