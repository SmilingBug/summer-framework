package com.yang.summerFramework.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @program: summer-framework
 * @description: 环绕增强
 * @author: yang Qiankun
 * @create: 2019-01-22 21:03
 **/
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Around----Before");
    }

    private void after() {
        System.out.println("Around----After");
    }
}
