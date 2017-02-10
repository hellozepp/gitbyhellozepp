package org1.MyProxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org1.netty.ClientHandler;

import java.util.logging.Logger;

/**
 * Created by hadoop on 16/11/18.
 * 链接随机生成的端口，实现端口映射
 */
public class ControlConnHandler extends ChannelHandlerAdapter{
    private static final Logger logger = Logger
            .getLogger(ClientHandler.class.getName());
    private final String body1;
    private final ChannelHandlerContext ctx1;
    private final ByteBuf message;

    public ControlConnHandler(String body, ChannelHandlerContext ctx) {
        this.body1=body;
        this.ctx1=ctx;
        byte[] req =body1.getBytes();
        message=Unpooled.buffer(req.length);
        message.writeBytes(req);
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(message);
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
        String body1 = new String(req, "UTF-8");
        System.out.println("来自服务端的数据: " + body1);

        //给客户端回消息
        ByteBuf resp = Unpooled.copiedBuffer(body1.getBytes());
        ctx1.writeAndFlush(resp);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.close();

    }
}
