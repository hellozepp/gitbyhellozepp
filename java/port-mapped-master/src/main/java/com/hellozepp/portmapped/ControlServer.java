package com.hellozepp.portmapped;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by hadoop on 16/11/18.
 */
public class ControlServer {
    private void bind(int port) {
        EventLoopGroup worker = null;
        EventLoopGroup boss = null;
        try {
            worker = new NioEventLoopGroup();
            boss = new NioEventLoopGroup();
            ServerBootstrap b = new ServerBootstrap();
            b.group(worker, boss)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            System.out.println("准备接收数据");
                            ch.pipeline().addLast(new HttpServerInboundHandler());//接受服务，读数据
                        }
                    });
            ChannelFuture future = b.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        System.out.println("中转服务端启动！！！");
        String[] realServer = new String[]{"8081", "8082", "8083","8084"};
        ConsisHash.setPort(realServer, 10000);
        new ControlServer().bind(8079);
    }
}
