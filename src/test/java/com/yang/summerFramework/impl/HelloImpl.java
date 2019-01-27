package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Hello;

/**
 * @program: summer-framework
 * @description: 实现类
 * @author: yang Qiankun
 * @create: 2019-01-20 18:26
 **/
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! "+ name);
    }
}
