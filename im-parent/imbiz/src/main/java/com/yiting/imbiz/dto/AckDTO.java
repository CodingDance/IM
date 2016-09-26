package com.yiting.imbiz.dto;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;

/**
 * Created by hzyiting on 2016/9/18.
 */
public class AckDTO implements IMSerializer {
	private long to;
	private String ackId;
	private String toServer;

	public AckDTO() {
	}

	public AckDTO(long to, String ackId, String toServer) {
		this.to = to;
		this.ackId = ackId;
		this.toServer = toServer;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public String getAckId() {
		return ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

	public String getToServer() {
		return toServer;
	}

	public void setToServer(String toServer) {
		this.toServer = toServer;
	}

	public DataBuffer encode(short version) throws UnWritableException {
		DataBuffer dataBuffer = new DataBuffer();
		dataBuffer.writeLong(to);
		dataBuffer.writeString(ackId);
		dataBuffer.writeString(toServer);
		return dataBuffer;
	}

	public void decode(DataBuffer buffer, short version) throws UnReadableException {
		to = buffer.readLong();
		ackId = buffer.readString();
		toServer = buffer.readString();
	}
}
