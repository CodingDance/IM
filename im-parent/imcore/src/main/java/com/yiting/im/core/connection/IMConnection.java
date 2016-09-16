package com.yiting.im.core.connection;

import com.yiting.im.core.transport.IMResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

/**
 * Created by hzyiting on 2016/9/16.
 * channel连接的封装类，提供serssion级别缓存，可以对连接发送数据和关闭等
 */
public class IMConnection {
	public static final AttributeKey<Long> ATTR_CONN_ID = AttributeKey.valueOf("connection_id");
	public static final AttributeKey<Long> ATTR_CONN_UIN = AttributeKey.valueOf("connection_uin");
	public static final AttributeKey<String> ATTR_CONN_ACCOUNT = AttributeKey.valueOf("connection_account");
	public static final AttributeKey<String> ATTR_CONN_SERVER = AttributeKey.valueOf("connection_server");

	private long mId;
	private volatile boolean isClosed=false;
	private ChannelHandlerContext mContext;
	private ConnectionCloseListener closeListener;

	public IMConnection(long mId,ChannelHandlerContext ctx){
		this.mId=mId;
		this.mContext=ctx;
	}

	public long getId() {
		return mId;
	}

	public long getUin() {
		return mContext.attr(IMConnection.ATTR_CONN_UIN).get();
	}

	public void setUin(long mUIN) {
		mContext.attr(IMConnection.ATTR_CONN_UIN).set(mUIN);
	}


	public String getAccount(){
		return mContext.attr(IMConnection.ATTR_CONN_ACCOUNT).get();
	}

	public void setAccount(String account){
		mContext.attr(IMConnection.ATTR_CONN_ACCOUNT).set(account);
	}

	public void setServerConn(String serverConn){mContext.attr(IMConnection.ATTR_CONN_SERVER).set(serverConn);}

	public String getServerConn(){return mContext.attr(IMConnection.ATTR_CONN_SERVER).get();}

	public boolean isActive() {
		return mContext != null && mContext.channel().isActive();
	}

	public boolean isClosed() {
		return isClosed || !isActive();
	}

	public boolean validate() {
		if (isClosed()) {
			return false;
		}
		// 可以考虑发送一个心跳包，同步等待success
		return true;
	}

	public void close() {
		if (!isClosed) {
			mContext.channel().close();
			notifyRemoved();
		}
	}

	public void notifyRemoved() {
		if (closeListener != null) {
			closeListener.onClosed(this);
		}
		isClosed = true;
		mContext = null;
		closeListener = null;
	}

	public void sendResponse(IMResponse resp) {
		if (isActive()) {
			mContext.writeAndFlush(resp);
		}
	}

	public void registerCloseListener(ConnectionCloseListener listener) {
		if (closeListener != null) {
			throw new IllegalStateException("Close listener already configured");
		}
		if (isClosed()) {
			listener.onClosed(this);
		} else {
			closeListener = listener;
		}
	}

	public void removeCloseListener(ConnectionCloseListener listener) {
		if (closeListener == listener) {
			closeListener = null;
		}
	}





	public interface ConnectionCloseListener{
		void onClosed(IMConnection connection);
	}

}
