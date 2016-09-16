package com.yiting.im.core.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class PacketDecoder extends LengthFieldBasedFrameDecoder{
	public PacketDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}
}
