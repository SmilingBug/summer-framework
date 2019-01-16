package com.yang.summerFramework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: summer-framework
 * @description: 反射工具类
 * @author: yang Qiankun
 * @create: 2019-01-13 19:48
 **/
public final class ReflectionUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method,Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field,Object value) {
        try {
            field.setAccessible(true);
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
