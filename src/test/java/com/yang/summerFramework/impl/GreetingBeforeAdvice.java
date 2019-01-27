package com.yang.summerFramework.impl;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: 前置增强类
 * @author: yang Qiankun
 * @create: 2019-01-22 20:37
 **/
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
