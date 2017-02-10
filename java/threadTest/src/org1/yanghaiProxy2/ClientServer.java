package org1.yanghaiProxy2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by yh on 16-11-3.
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
        //配置真实主机
        //最初节点
         VirtualPort.addPost(new String[]{"8080", "8081", "8082"});
        //添加节点
      //  VirtualPort.addPost(new String[]{"8080", "8081", "8082","8083"});
        //减少节点
        //VirtualPort.addPost(new String[]{"8080", "8081"});

        new ClientServer().bind(8079);
    }
}
