package com.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * Created by Administrator on 2017/3/17.
 */
@Component
public class NettyServer implements InitializingBean {

    @Resource
    private ChannelInitializer<SocketChannel> childHandler;

    @Value("${netty.host}")
    private String host;

    @Value("${netty.port}")
    private int port;
    @Override
    public void afterPropertiesSet() throws Exception {
        EventLoopGroup parentGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors()*2);
        EventLoopGroup childGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        ServerBootstrap server = new ServerBootstrap();
        server.group(parentGroup, childGroup);
        server.channel(NioServerSocketChannel.class);
        server.childHandler(childHandler);
        server.bind(new InetSocketAddress(host, port)).sync();
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

    public ChannelInitializer<SocketChannel> getChildHandler() {
        return childHandler;

    }

    public void setChildHandler(ChannelInitializer<SocketChannel> childHandler) {
        this.childHandler = childHandler;
    }
}
