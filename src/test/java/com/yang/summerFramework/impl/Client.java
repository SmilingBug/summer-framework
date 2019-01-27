package com.yang.summerFramework.impl;

import com.yang.summerFramework.demo.Apology;
import com.yang.summerFramework.demo.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: summer-framework
 * @description: Client
 * @author: yang Qiankun
 * @create: 2019-01-22 20:53
 **/
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-aspectJ-config.xml");
        Greeting greetingImpl = (Greeting) context.getBean("greetingImpl");

        greetingImpl.sayHello("hhhhhhhhh");

    }

}
