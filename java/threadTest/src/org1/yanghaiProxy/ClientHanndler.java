package org1.yanghaiProxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yh on 16-11-3.
 */
public class ClientHanndler extends ChannelHandlerAdapter{

    private final ByteBuf firstMessage;
    public ClientHanndler(String text){
         byte[] req = text.getBytes();
         firstMessage = Unpooled.buffer(req.length);//分配缓冲区大小
         firstMessage.writeBytes(req);//写入内容
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);//刷写所有
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //Thread.currentThread().sleep(2*1000);
        //===========================
        System.out.println("AAAAA");
        //===========================
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"utf-8");
        System.out.println("服务端的数据为："+body);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("thisDemo have a problem!!!!!");
    }
}
