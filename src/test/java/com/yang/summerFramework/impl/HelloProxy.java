package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Hello;

/**
 * @program: summer-framework
 * @description: 代理类，代理HelloImpl
 * @author: yang Qiankun
 * @create: 2019-01-20 18:52
 **/
public class HelloProxy implements Hello {

    /**
     * 注入Hello接口
     */
    private Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("yangqiankun");
    }
}
