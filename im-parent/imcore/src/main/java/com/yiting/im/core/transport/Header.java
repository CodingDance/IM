package com.yiting.im.core.transport;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class Header implements IMSerializer {

	//协议头header 8字节
	public static final int PROTOCOL_HEADER_LENGTH = 8;
	//数据包总长度
	private int length;
	//版本信息
	private short version;
	//SID
	private short handlerId;
	//CID
	private short commandId;
	//保留字段
	private short reserved;

	public static int getProtocolHeaderLength() {
		return PROTOCOL_HEADER_LENGTH;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public short getVersion() {
		return version;
	}

	public void setVersion(short version) {
		this.version = version;
	}

	public short getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(short handlerId) {
		this.handlerId = handlerId;
	}

	public short getCommandId() {
		return commandId;
	}

	public void setCommandId(short commandId) {
		this.commandId = commandId;
	}

	public short getReserved() {
		return reserved;
	}

	public void setReserved(short reserved) {
		this.reserved = reserved;
	}

	public DataBuffer encode(short version) throws UnWritableException{
		DataBuffer dataBuffer=new DataBuffer(PROTOCOL_HEADER_LENGTH);
		dataBuffer.writeShort(version);
		dataBuffer.writeShort(handlerId);
		dataBuffer.writeShort(commandId);
		dataBuffer.writeShort(reserved);
		return dataBuffer;
	}

	public void decode(DataBuffer buffer, short ver) throws UnReadableException{
		this.version = buffer.readShort();
		handlerId = buffer.readShort();
		commandId = buffer.readShort();
		reserved = buffer.readShort();
	}


	@Override
	public String toString() {
		return "Header{" +
				"length=" + length +
				", version=" + version +
				", handlerId=" + handlerId +
				", commandId=" + commandId +
				", reserved=" + reserved +
				'}';
	}
}
