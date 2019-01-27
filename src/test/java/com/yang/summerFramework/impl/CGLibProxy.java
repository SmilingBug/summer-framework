package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Hello;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: CGLib实现动态代理
 * @author: yang Qiankun
 * @create: 2019-01-20 22:12
 **/
public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        return instance;
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls,this);
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("yang");
    }
}
