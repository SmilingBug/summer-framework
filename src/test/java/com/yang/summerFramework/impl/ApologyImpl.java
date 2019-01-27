package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Apology;

/**
 * @program: summer-framework
 * @description: Apology实现类
 * @author: yang Qiankun
 * @create: 2019-01-27 21:58
 **/
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("I am apologyImpl:"+name);
    }
}
