package com.yang.summerFramework.helper;

import com.yang.summerFramework.annotation.Inject;
import com.yang.summerFramework.util.ArrayUtil;
import com.yang.summerFramework.util.CollectionUtil;
import com.yang.summerFramework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @program: summer-framework
 * @description: 依赖注入助手类
 * @author: yang Qiankun
 * @create: 2019-01-13 21:26
 **/
public final class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称BeanMap）
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历beanMap
            for (Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()) {
                //从beanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取bean类定义的所有成员变量（简称Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前Bean Field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
