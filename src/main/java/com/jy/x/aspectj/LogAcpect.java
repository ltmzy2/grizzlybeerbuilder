package com.jy.x.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-21 15:43
 **/
@Slf4j
@Aspect
@Component
public class LogAcpect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    public LogAcpect() {
    }

    private String formatDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private String formatDate(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
    }

    @Before("JoinPointConfig.doServiceAcpect()")
    public void doServiceBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        long time = System.currentTimeMillis();
        startTime.set(time);
        log.info("时间:{}->类名:{}->方法名:{}", formatDate(time), signature.getDeclaringTypeName(), signature.getName());
    }

    @Before("JoinPointConfig.doControllerAcpect()")
    public void doControllerBefore() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        long time = System.currentTimeMillis();
        startTime.set(time);
        log.info("时间:{}->请求者:{}->请求接口:{}", formatDate(time), request.getRequestedSessionId(), request.getRequestURI());
    }

    @After("JoinPointConfig.doControllerAcpect()")
    public void doControllerAfter() {
        log.info("执行耗时:{}", (System.currentTimeMillis() - startTime.get()) + "毫秒");
        log.info("------------------------------------------------------");
    }

    private static String[] types = {"java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float"};
}
