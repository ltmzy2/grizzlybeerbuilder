package com.jy.x.aspectj;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @program: gen
 * @author: Jy
 * @create: 2019-08-21 16:11
 **/
public class JoinPointConfig {

    @Pointcut("execution(public * com.jy.x.service.*.*(..))")
    public void doServiceAcpect() {
    }

    @Pointcut("execution(public * com.jy.x.controller.*.*(..))")
    public void doControllerAcpect() {
    }

    @Pointcut("execution(public * com.jy.x.service.GenerateService.genService(..))")
    public void doDelZipAcpect() {
    }
}
