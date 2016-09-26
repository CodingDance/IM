package com.yiting.im.core.handler;


import com.yiting.im.core.connection.IMConnection;

/**
 * Handler
 * 
 * @author hzyiting
 *
 */
public abstract class IMHandler<T> {
	public abstract short getId();

	public abstract void dispatch(IMConnection connection, T data);
}
