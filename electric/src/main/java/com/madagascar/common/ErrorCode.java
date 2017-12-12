package com.madagascar.common;

/**
 * @Creator future
 * @Date 02/09/2017 2:19 PM
 * @DESC #DESC#   返回状态码接口
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:19 PM
 * @LOG $log$
 */
public interface ErrorCode {
    int STATUS_CODE_SUCCESS = 1;
    int STATUS_CODE_WARN = 0;
    int STATUS_CODE_ERROR = 0;
    int STATUS_CODE_INFO = 0;
    int STATUS_CODE_TOKEN_EXPIRED = 0;

    String WARN_ARGUMENT = "参数错误";
    String ERROR_INTERNAL_SERVER_ERROR = "服务器内部错误";
    String ERROR_FORBIDDEN_OPER = "非法操作";
    String ERROR_TOKEN_EXPIRED = "登陆过期，请重新登录";
    String ERROR_USER_OR_PWD_WRONG = "用户名或者密码错误";
    String ERROR_RENAME="用户名已存在";

}
