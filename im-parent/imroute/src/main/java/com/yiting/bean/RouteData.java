package com.yiting.bean;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;

/**
 * Created by hzyiting on 2016/9/26.
 */
public class RouteData implements IMSerializer {
	private short type;     //user or room
	private long to;        //to user_uin or room code
	private DataBuffer data;

	public RouteData(DataBuffer data) {
		try {
			decode(data, (short) 0);
		} catch (UnReadableException e) {
			e.printStackTrace();
		}
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public DataBuffer getData() {
		return data;
	}

	public void setData(DataBuffer data) {
		this.data = data;
	}

	public DataBuffer encode(short version) throws UnWritableException {
		DataBuffer buffer = new DataBuffer();
		buffer.writeShort(type);
		buffer.writeLong(to);
		buffer.writeDataBuffer(data);
		return buffer;
	}

	public void decode(DataBuffer buffer, short version) throws UnReadableException {
		this.type = buffer.readShort();
		this.to = buffer.readLong();
		this.data = buffer.readDataBuffer();
	}
}
