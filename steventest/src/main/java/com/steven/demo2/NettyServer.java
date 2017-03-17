package com.steven.demo2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Administrator on 2017/3/17.
 */
public class NettyServer {

    public void bind() throws InterruptedException {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG,1024)
            .childHandler(new ChildChannelHandler());

            // 绑定端口
            ChannelFuture f = b.bind(5353).sync();
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        }finally {
            boosGroup.shutdownGracefully().sync();
            workGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer().bind();
    }
}
