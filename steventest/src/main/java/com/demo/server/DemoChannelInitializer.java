package com.demo.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/17.
 */
@Component
public class DemoChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private ChannelHandler logging;
    @Resource
    private ChannelHandler decoder;
    @Resource
    private ChannelHandler encoder;
    @Resource
    private ChannelHandler lengthEncoder;
    @Resource
    private ChannelHandler handler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast(logging)
                .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4))
                .addLast(lengthEncoder)
                .addLast(decoder)
                .addLast(encoder)
                .addLast(handler);
    }
}
