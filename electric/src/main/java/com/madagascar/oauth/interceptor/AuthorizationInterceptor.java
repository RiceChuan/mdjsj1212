package com.madagascar.oauth.interceptor;


import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.madagascar.common.Properties;
import com.madagascar.dao.TokenMapper;
import com.madagascar.execption.AuthFailedException;
import com.madagascar.model.Token;
import com.madagascar.oauth.annotation.Authorization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Creator future
 * @Date 25/01/2017 13:13
 * @Desc #desc#   自定义的拦截器   返回ture继续向下执行，返回false取消当前请求
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 25/01/2017 13:13
 * @Desc $REASON$
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenMapper mTokenMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(Authorization.class) != null) {
                    HttpSession session =request.getSession();
        if(session.getAttribute("username")!=null ){
            return true;
        }else {
            response.sendRedirect("/");
            return false;
        }
//            String authorization = request.getHeader(Properties.KEY_AUTHORIZATION);
//            Token token = mTokenMapper.findByToken(authorization);
//            if (token != null && StringUtils.isNotBlank(token.getToken())) {
//                request.setAttribute(Properties.KEY_UID, token.getUid());
//            } else {
//                throw new AuthFailedException();
//            }
        }
        return true;
    }
}
