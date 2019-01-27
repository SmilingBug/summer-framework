package com.yang.summerFramework.impl;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: 后置增强
 * @author: yang Qiankun
 * @create: 2019-01-22 20:45
 **/
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After");
    }
}
