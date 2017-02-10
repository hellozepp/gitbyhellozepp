package org1.yanghaiProxy2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org1.yanghaiProxy.ClientHanndler;

/**
 * Created by yh on 16-11-3.
 */
public class Client {
    public String s ="";
    public Client(String s){
        this.s = s;
    }
    public void connect(int port,String host){
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHanndler(s));
                        }
                    });
            ChannelFuture f =b.connect(host,port).sync();
            f.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            group.shutdownGracefully();

        }
    }
    public static void main(String[] args) {
        for(int i=1;i<500;i++){
            Thread a =new Thread(){

            };
            new Client(i+"").connect(8079,"127.0.0.1");
        }

         //   new Client(100+"").connect(8079,"127.0.0.1");

    }
}
