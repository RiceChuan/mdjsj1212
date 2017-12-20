package com.madagascar.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Creator future
 * @Date 24/12/2016 16:31
 * @Desc #desc# 返回类型
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 24/12/2016 16:31
 * @Desc $REASON$
 */

@Setter
@Getter
public class RestResult<T> {
    @JsonProperty("code")
    private int status;

    private String msg;

    private T data;

    RestResult(int status) {
        this.status = status;
    }

    RestResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    RestResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> RestResult<T> success(String msg) {
        return new RestResult<>(ErrorCode.STATUS_CODE_SUCCESS, msg);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(ErrorCode.STATUS_CODE_SUCCESS, data);
    }

    public static <T> RestResult<T> error(String error) {
        return new RestResult<>(ErrorCode.STATUS_CODE_ERROR, error);
    }

    public static <T> RestResult<T> error() {
        return new RestResult<>(ErrorCode.STATUS_CODE_ERROR);
    }

    public static <T> RestResult<T> warn() {
        return new RestResult<>(ErrorCode.STATUS_CODE_WARN);
    }

    public static <T> RestResult<T> warn(String warn) {
        return new RestResult<>(ErrorCode.STATUS_CODE_WARN, warn);
    }

    public static <T> RestResult<T> info(String info) {
        return new RestResult<>(ErrorCode.STATUS_CODE_INFO, info);
    }

    public static <T> RestResult<T> tokenExpired() {
        return new RestResult<>(ErrorCode.STATUS_CODE_TOKEN_EXPIRED, ErrorCode.ERROR_TOKEN_EXPIRED);
    }

    public static <T> RestResult<T> forbidden() {
        return new RestResult<>(ErrorCode.STATUS_CODE_ERROR, ErrorCode.ERROR_FORBIDDEN_OPER);
    }

    public static <T> RestResult<T> internalError() {
        return new RestResult<>(ErrorCode.STATUS_CODE_INFO, ErrorCode.ERROR_INTERNAL_SERVER_ERROR);
    }

    public static <T> RestResult<T> argumentError() {
        return new RestResult<>(ErrorCode.STATUS_CODE_WARN, ErrorCode.WARN_ARGUMENT);
    }

    @JsonIgnore
    private Boolean isSuccess() {
        return this.status == ErrorCode.STATUS_CODE_SUCCESS;
    }

}
