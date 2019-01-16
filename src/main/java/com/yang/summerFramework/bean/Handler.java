package com.yang.summerFramework.bean;

import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: 封装Action信息
 * @author: yang Qiankun
 * @create: 2019-01-14 22:10
 **/
public class Handler {
    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
