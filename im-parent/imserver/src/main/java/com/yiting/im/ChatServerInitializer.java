package com.yiting.im;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by hzyiting on 2016/9/12.
 */
public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline=ch.pipeline();

		pipeline.addLast("decoder",)
	}
}
