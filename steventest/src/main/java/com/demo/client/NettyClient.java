package com.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2017/3/17.
 */
@Component
public class NettyClient implements InitializingBean {

    @Resource
    private ChannelInitializer<SocketChannel> childHandler;
    @Value("${netty.host}")
    private String host;
    @Value("${netty.port}")
    private int port;


    @Override
    public void afterPropertiesSet() throws Exception {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        Bootstrap server = new Bootstrap();
        server.group(parentGroup);
        server.channel(NioSocketChannel.class);
        server.handler(childHandler);
        server.connect(new InetSocketAddress(host, port));
    }

    public ChannelInitializer<SocketChannel> getChildHandler() {
        return childHandler;
    }

    public void setChildHandler(ChannelInitializer<SocketChannel> childHandler) {
        this.childHandler = childHandler;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
