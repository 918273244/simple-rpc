package com.loader.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ClientLoader {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("classpath:netty-client.xml");
        System.out.println("client : "+c);
    }

}
