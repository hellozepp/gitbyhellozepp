package org1.MyProxy;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

//import io.netty.channel.ChannelHandlerAppender;

/**
 * Created by hadoop on 16/11/18.什么时候自动装箱
 例如：Integer i = 100;
 相当于编译器自动为您作以下的语法编译：Integer i = Integer.valueOf(100);
 * Integer i = 10; //装箱
 2  int t = i; //拆箱，实际上执行了 int t = i.intValue();
 */
public class ControlServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("自客户端的数据: " + body);
        //随即分配
//        Random random = new Random();
//        int n = random.nextInt(2);
//        new ProxyServer(ctx,body).connect(PortCollection.getPort(n), "127.0.0.1");
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
            System.out.println("开始转发");
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
                        .handler(new ControlConnHandler(body,ctx));
                ChannelFuture future = bootstrap.connect(ip, port).sync();
                future.channel().closeFuture().sync();

            }catch (Exception e){

            }finally {
                b.shutdownGracefully();
            }
        }
    }
}