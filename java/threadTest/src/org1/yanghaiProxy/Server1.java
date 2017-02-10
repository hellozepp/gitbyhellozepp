package org1.yanghaiProxy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by yh on 16-11-3.
 */
public class Server1 {
    public void bind(int port){
        EventLoopGroup workBoss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try{
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(workBoss,work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .childHandler(new ServerHanndler1());

            ChannelFuture future = boot.bind(port).sync();
            future.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
           work.shutdownGracefully();
           workBoss.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new Server1().bind(8080);
    }
}
