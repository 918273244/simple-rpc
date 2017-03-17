package com.loader.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ServerLoader {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("classpath:netty-server.xml");
        System.out.println("server: "+c);
    }
}
