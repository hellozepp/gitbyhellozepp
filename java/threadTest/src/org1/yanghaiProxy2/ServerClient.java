package org1.yanghaiProxy2;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by yh on 16-11-3.
 */
public class ServerClient {
    private String boby;
    private ChannelHandlerContext cetx;
    public ServerClient(String boby,ChannelHandlerContext cetx){
        this.boby =boby;
        this.cetx =cetx;
    }
    public void connect(int port,String host){
        EventLoopGroup b =new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(b)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ServerClientHanndler(boby,cetx));
            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();

        }catch (Exception e){

        }finally {
         b.shutdownGracefully();
        }

    }
}
