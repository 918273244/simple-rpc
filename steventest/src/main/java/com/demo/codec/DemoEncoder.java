package com.demo.codec;

import com.demo.model.PackageModel;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class DemoEncoder extends MessageToMessageEncoder<PackageModel> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, PackageModel msg, List<Object> out) throws Exception {
        ByteBuf buf = PooledByteBufAllocator.DEFAULT.buffer(4);
        buf.writeInt(msg.getId());
        out.add(buf);
    }
}
