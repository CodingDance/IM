package com.yiting.im.core.transport;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;

/**
 * Created by hzyiting on 2016/9/13.
 */
public interface IMSerializer {

	/**
	 * 对数据进行编码
	 * @param version
	 * @return
	 */
	DataBuffer encode(short version) throws UnWritableException;

	/**
	 * 对数据进行解码
	 * @param buffer
	 * @param version
	 */
	void decode(DataBuffer buffer,short version) throws UnReadableException;
}
