package com.yang.summerFramework.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: summer-framework
 * @description: 基于注解：通过AspectJ execution 表达式拦截方法
 * @author: yang Qiankun
 * @create: 2019-01-27 20:53
 **/
@Aspect
@Component
public class GreetingAspect {

    @Around("@annotation(com.yang.summerFramework.annotation.Tag)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        before();
        Object object = joinPoint.proceed();
        after();
        return object;
    }

    private void before() {
        System.out.println("Before----------");
    }

    private void after() {
        System.out.println("After----------");
    }
}
