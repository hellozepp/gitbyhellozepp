package org1.yanghaiProxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * Created by yh on 16-11-3.
 */
public class ChildChannelHandler extends ChannelInitializer{
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new ClietnSeverHanndler());
    }
}
