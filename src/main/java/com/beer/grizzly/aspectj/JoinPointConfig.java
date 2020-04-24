package com.beer.grizzly.aspectj;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {

    @Pointcut("execution(public * com.jy.x.service.*.*(..))")
    public void doServiceAcpect() {
    }

    @Pointcut("execution(public * com.jy.x.controller.*.*(..))")
    public void doControllerAcpect() {
    }

    @Pointcut("execution(public * com.beer.grizzly.service.GenerateService.genService(..))")
    public void doDelZipAcpect() {
    }
}
