package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Apology;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @program: summer-framework
 * @description: 引入增强
 * @author: yang Qiankun
 * @create: 2019-01-24 22:20
 **/
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("I am Sorry!" + name);
    }
}
