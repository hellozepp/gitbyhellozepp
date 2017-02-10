package org1.netty;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by hadoop on 16-10-28.
 * 接受的模版
 * 四步 转换类型 获取数组 读字节数 转成编码
 */
public class serverHandler extends ChannelHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;//转换类型
        byte[] req = new byte[buf.readableBytes()];//获取到byte数组
        buf.readBytes(req);//读字节数
        String body = new String(req, "UTF-8");//转成编码格式
        System.out.println("来自客户端的数据: " + body);
        ByteBuf resp = Unpooled.copiedBuffer("收到请求！".getBytes());
        ctx.writeAndFlush(resp);
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
