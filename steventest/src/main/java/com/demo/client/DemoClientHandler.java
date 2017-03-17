package com.demo.client;

import com.demo.model.PackageModel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/17.
 */
@Component("handler")
public class DemoClientHandler extends
        SimpleChannelInboundHandler<PackageModel> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        PackageModel m = new PackageModel();
        m.setId(10);
        ctx.writeAndFlush(m);
        ctx.writeAndFlush("test");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PackageModel packageModel) throws Exception {

    }
}
