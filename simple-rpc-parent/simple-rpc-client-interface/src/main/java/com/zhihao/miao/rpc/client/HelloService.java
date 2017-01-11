package com.zhihao.miao.rpc.client;

public interface HelloService {

    String hello(String name);

    String hello(Person person);
}
