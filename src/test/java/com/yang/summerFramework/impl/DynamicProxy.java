package com.yang.summerFramework.impl;


import com.yang.summerFramework.demo.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: summer-framework
 * @description: 动态代理
 * @author: yang Qiankun
 * @create: 2019-01-20 19:38
 **/
public class DynamicProxy implements InvocationHandler {
    /**
     * 被代理的目标对象
     */
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        //Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),dynamicProxy);
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("jack");

    }
}
