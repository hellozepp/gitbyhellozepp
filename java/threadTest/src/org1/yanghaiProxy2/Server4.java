package org1.yanghaiProxy2;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by yh on 16-11-3.
 */
public class Server4 {
    public void bind(int port){
        EventLoopGroup workBoss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try{
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(workBoss,work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    //.childHandler(new ServerHanndler3());
                    .childHandler(new ChilderChannelHanndler());

            ChannelFuture future = boot.bind(port).sync();
            future.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
            work.shutdownGracefully();
            workBoss.shutdownGracefully();

        }
    }
    public static void main(String[] args) {
        new Server4().bind(8083);
    }

    private class ChilderChannelHanndler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new ServerHanndler4());
        }
    }
}
