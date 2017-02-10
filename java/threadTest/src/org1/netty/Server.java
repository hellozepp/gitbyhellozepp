//package org1.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.epoll.EpollEventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
//
///**
// * Created by hadoop on 16-10-28.
// */
//public class Server {
//    private static final EventLoopGroup bossGroup = new NioEventLoopGroup();
//    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();
//    public void connect(String host,int port) throws InterruptedException {
//        final ServerBootstrap bootstrap =new ServerBootstrap();
//        try {
//            EventLoopGroup worker =new NioEventLoopGroup();
//            bootstrap.group(worker)
//                .option(ChannelOption.SO_BACKLOG, 1024)
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<Channel>() {
//            @Override
//            protected void initChannel(Channel ch) throws Exception {
//                ch.pipeline().addLast(new serverHandler());
//            }
//        });
//            ChannelFuture f = bootstrap.connect(host, port).sync();
//        f.channel().closeFuture().sync();}
//        finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//        int port =8081;
//        new Server1().bind(port);
//        new Server(12).connect(8081, "127.0.0.1");
//    }
//}
