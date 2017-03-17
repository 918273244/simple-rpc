package com.demo.server;

import com.demo.model.PackageModel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/17.
 */
@Component("handler")
public class DemoServerHandler extends SimpleChannelInboundHandler<PackageModel> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PackageModel msg) throws Exception {
        System.out.println(msg);
    }
}
