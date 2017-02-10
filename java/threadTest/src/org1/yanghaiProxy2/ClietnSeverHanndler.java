package org1.yanghaiProxy2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yh on 16-11-3.
 */
public class ClietnSeverHanndler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("自客户端的数据: " + body);

        //端口转发
//      Random random = new Random();
//      int n = random.nextInt(3);
//      new ServerClient(body,ctx).connect(PortCollection.getPort(n),"127.0.0.1");


        //一致性hash端口映射
        String stringport = VirtualPort.getrealServer(body+"");// 对数据HASH% 散步到环上
        System.out.println(stringport);
        int port =Integer.valueOf(stringport);
        new ServerClient(body,ctx).connect(port,"127.0.0.1");


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("thisDemo have a problem!!!");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }
}
