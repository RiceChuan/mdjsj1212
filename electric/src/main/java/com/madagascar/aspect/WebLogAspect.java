package com.madagascar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Creator future
 * @Date 17/01/2017 08:53
 * @Desc 通过aop打印每个接口消耗时间
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 17/01/2017 08:53
 * @Desc $REASON$
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect { 
    private final Logger mLogger = LoggerFactory.getLogger(this.getClass());
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.madagascar.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        mLogger.info("URL: " + request.getRequestURL().toString());
        mLogger.info("HTTP_METHOD: " + request.getMethod());
        mLogger.info("IP: " + request.getRemoteAddr());
        mLogger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        mLogger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        mLogger.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()) + "ms");
    }
}
