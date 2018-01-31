package com.hellozepp.portmapped;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.logging.Logger;

public class HttpServerInboundHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(HttpServerInboundHandler.class.getName());
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);//去掉乱码
        String body = new String(req, "UTF-8");
        logger.info("自客户端的数据: " + body);
        //一致性哈希
        int port = Integer.valueOf(ConsisHash.getPort(body));
        new ProxyServer(ctx,body).connect(port,"127.0.0.1");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
    class ProxyServer {
        private final String body;
        private final ChannelHandlerContext ctx;

        public ProxyServer(ChannelHandlerContext ctx, String body) {
            logger.info("开始转发");
            this.body =body;
            this.ctx =ctx;
        }

        public void connect(Integer port, String ip) {
            EventLoopGroup b = new NioEventLoopGroup();
            try{
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(b)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY,true)
                        .handler(new HttpServerOutboundHandler(body,ctx));
                ChannelFuture future = bootstrap.connect(ip, port).sync();
                future.channel().closeFuture().sync();

            }catch (Exception e){

            }finally {
                b.shutdownGracefully();
            }
        }
    }
}
