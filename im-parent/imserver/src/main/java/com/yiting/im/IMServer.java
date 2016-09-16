package com.yiting.im;

import com.yiting.im.config.Constant;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by hzyiting on 2016/9/12.
 */
public class IMServer {
	private final int PORT;

	public IMServer() {
		this.PORT = Constant.PORT1.getValue();
	}

	public IMServer(int PORT) {
		this.PORT = PORT;
	}

	public void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap=new ServerBootstrap().group(bossGroup,workGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChatServerInitializer());
		}catch (Exception ex){

		}
	}


}
