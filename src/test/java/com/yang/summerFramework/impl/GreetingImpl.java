package com.yang.summerFramework.impl;

import com.yang.summerFramework.annotation.Tag;
import com.yang.summerFramework.demo.Greeting;
import org.springframework.stereotype.Component;

/**
 * @program: summer-framework
 * @description: impl
 * @author: yang Qiankun
 * @create: 2019-01-22 20:50
 **/
@Component
public class GreetingImpl implements Greeting {

    @Tag
    @Override
    public void sayHello(String name) {
        System.out.println("Hello !" + name);
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning!" + name);
    }

    @Tag
    public void goodNight(String name) {
        System.out.println("Good Night!" + name);
    }
}
