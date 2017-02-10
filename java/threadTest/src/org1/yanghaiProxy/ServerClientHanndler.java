package org1.yanghaiProxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yh on 16-11-3.
 */
public class ServerClientHanndler extends ChannelHandlerAdapter {
    private String bodys;
    private ChannelHandlerContext ctex;
    private ByteBuf message;

    public ServerClientHanndler(String body, ChannelHandlerContext cetx) {
        this.bodys = body;
        this.ctex =cetx;
        byte[] req = bodys.getBytes();
        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(message);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body1 = new String(req, "UTF-8");
        System.out.println("来自服务端的数据: " + body1);

        //给客户端回消息
        ByteBuf resp = Unpooled.copiedBuffer(body1.getBytes());
        ctex.writeAndFlush(resp);
        System.out.println("BBB");
        // ctex.flush();
        //  ctex.close();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();

    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("thisDemo have problem!!!");
    }
}
