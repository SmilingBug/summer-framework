package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Apology;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @program: summer-framework
 * @description: Spring+ aspectJ（引入增强）
 * @author: yang Qiankun
 * @create: 2019-01-27 21:55
 **/

@Aspect
@Component
public class GreetingIntroAspect {

    @DeclareParents(value = "com.yang.summerFramework.impl.GreetingImpl",defaultImpl = ApologyImpl.class)
    private Apology apology;
}
