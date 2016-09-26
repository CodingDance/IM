package com.yiting.im.core.codec;

import com.yiting.im.core.transport.IMResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by hzyiting on 2016/9/17.
 */
public class PacketEncoder extends MessageToByteEncoder<IMResponse> {
	@Override
	protected void encode(ChannelHandlerContext ctx, IMResponse msg, ByteBuf out) throws Exception {
		out.writeBytes(msg.encode().getOrignalBuffer());
	}
}
