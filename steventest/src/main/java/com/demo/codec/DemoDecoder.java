package com.demo.codec;

import com.demo.model.PackageModel;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class DemoDecoder extends MessageToMessageDecoder<ByteBuf>{
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf msg, List<Object> out) throws Exception {
        int id = msg.readInt();
        PackageModel packageModel = new PackageModel();
        packageModel.setId(id);
        out.add(packageModel);
    }
}
