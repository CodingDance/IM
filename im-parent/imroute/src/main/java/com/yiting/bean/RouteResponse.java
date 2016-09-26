package com.yiting.bean;

import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMResponse;

/**
 * Created by hzyiting on 2016/9/26.
 */
public class RouteResponse extends IMResponse {
	private DataBuffer mRawData;

	public RouteResponse(DataBuffer mRawData) {
		this.mRawData = mRawData;
	}

	public DataBuffer getRawData() {
		return mRawData;
	}

	public void setRawData(DataBuffer mRawData) {
		this.mRawData = mRawData;
	}

	@Override
	public DataBuffer encode() {
		return mRawData;
	}
}
