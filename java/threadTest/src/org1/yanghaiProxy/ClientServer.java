package org1.yanghaiProxy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by yh on 16-11-3.
 * 负责转发
 */
public class ClientServer {
    public void bind(int port){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workgroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workgroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture future = b.bind(port).sync();
            future.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
             bossGroup.shutdownGracefully();
             workgroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
        new ClientServer().bind(8079);
    }
}
