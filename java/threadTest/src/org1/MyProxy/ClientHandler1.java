package org1.MyProxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org1.netty.ClientHandler;

import java.util.logging.Logger;

/**
 * Created by hadoop on 16/11/17.
 */
public class ClientHandler1 extends ChannelHandlerAdapter {
    private static final Logger logger = Logger
            .getLogger(ClientHandler.class.getName());
    private final ByteBuf firstMessage;
    public ClientHandler1(String s) {
        System.out.println("客户端启动！！！");
        byte[] req = s.getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("Unexpected exception from downstream : "
                + cause.getMessage());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("来自服务端的数据: " + body);
        ctx.close();
    }
}
