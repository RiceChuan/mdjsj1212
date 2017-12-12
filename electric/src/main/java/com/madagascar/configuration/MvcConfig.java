package com.madagascar.configuration;

import com.madagascar.oauth.interceptor.AuthorizationInterceptor;
import com.madagascar.oauth.resolver.CurrentUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Creator future
 * @Date 25/01/2017 15:48
 * @Desc #desc#
 * <p>
 * @Updator $AUTHOR$    springboot拦截器 配置
 * @UpdateTime 25/01/2017 15:48
 * @Desc $REASON$
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorizationInterceptor mAuthorizationInterceptor;

    @Autowired
    private CurrentUserMethodArgumentResolver mCurrentUserMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个自定义拦截器规则
        registry.addInterceptor(mAuthorizationInterceptor);
//        registry.addInterceptor(mAuthorizationInterceptor).addPathPatterns("/**").excludePathPatterns("/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(mCurrentUserMethodArgumentResolver);
    }

}
