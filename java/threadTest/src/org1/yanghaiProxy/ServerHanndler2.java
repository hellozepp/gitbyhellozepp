package org1.yanghaiProxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yh on 16-11-3.
 */
public class ServerHanndler2 extends ChannelHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String str = new String(req,"utf-8");
        System.out.println("客户端的消息为:"+str);

        ByteBuf byteBuf = Unpooled.copiedBuffer("8081服务器开始服务！！！".getBytes());
        ctx.writeAndFlush(byteBuf);


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
//        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("thisDemo have a problem");
    }
}
