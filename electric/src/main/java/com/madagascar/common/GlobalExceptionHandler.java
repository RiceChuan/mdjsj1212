package com.madagascar.common;


import com.madagascar.execption.AuthFailedException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Creator future
 * @Date 02/09/2017 2:12 PM
 * @DESC #DESC#  全局异常捕获
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:12 PM
 * @LOG $log$
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final Logger mLogger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public HttpStatus getHttpStatus(HttpServletRequest request, Exception exception) {
        return HttpStatus.OK;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestResult> handleDefaultException(Exception exception, HttpServletRequest request) {
        log.error(getRequestURI(request) + " [ " + exception.getMessage() + " ]");
        return new ResponseEntity<>(RestResult.error(), getHttpStatus(request, exception));
    }

    @ExceptionHandler(AuthFailedException.class)
    private ResponseEntity<RestResult> handleDefaultException(AuthFailedException exception, HttpServletRequest request) {
        log.error(getRequestURI(request) + " [ " + exception.getMessage() + " ]");
        return new ResponseEntity<>(RestResult.tokenExpired(), getHttpStatus(request, exception));
    }


    private String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }


}
