package com.hellozepp.portmapped;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

public class HttpServerOutboundHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(HttpServerInboundHandler.class.getName());
    private String body1;
    private ChannelHandlerContext ctx1;
    private ByteBuf message=null;//之前没有把message谢出去
    HttpServerOutboundHandler(String body, ChannelHandlerContext ctx) {
        this.body1 = body;
        this.ctx1 = ctx;
        byte[] req =body1.getBytes();
        message=Unpooled.buffer(req.length);
        message.writeBytes(req);
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(message);
    }



    //给客户端回消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        ctx1.writeAndFlush(buf);
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        body1 = new String(req, "UTF-8");
        System.out.println("来自real节点的数据: " + body1);

        //给客户端回消息
        ByteBuf resp = Unpooled.copiedBuffer(body1.getBytes());
        ctx1.writeAndFlush(resp);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("Unexpected exception from downstream : "
                + cause.getMessage());
        ctx.close();
    }


}
