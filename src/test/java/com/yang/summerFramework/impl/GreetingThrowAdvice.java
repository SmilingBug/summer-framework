package com.yang.summerFramework.impl;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: 抛出增强
 * @author: yang Qiankun
 * @create: 2019-01-24 21:55
 **/
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,Object[] args,Object target,Exception e) {
        System.out.println("-----------throw Exception-------------");
        System.out.println("target Class:" + target.getClass().getName());
        System.out.println("Method name: "+ method.getName());
        System.out.println("Exception Message:" +e.getMessage());
        System.out.println("-----------------------------------");
    }
}
