package com.yiting.imbiz.dto;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;
import com.yiting.imbiz.entity.Message;

/**
 * Created by hzyiting on 2016/9/18.
 */
public class MessageDTO implements IMSerializer {

	private Message message;

	public MessageDTO() {
	}

	public MessageDTO(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public DataBuffer encode(short version) throws UnWritableException {
		DataBuffer buffer = new DataBuffer();
		buffer.writeString(message.getId());
		buffer.writeLong(message.getTo());
		buffer.writeLong(message.getFrom());
		buffer.writeByte(message.getType());
		buffer.writeString(message.getMessage());
		buffer.writeLong(message.getCreateAt());
		buffer.writeString(message.getFromServer());
		buffer.writeString(message.getToServer());
		return buffer;
	}

	public void decode(DataBuffer buffer, short version) throws UnReadableException {
		if (message == null) {
			message = new Message();
		}
		message.setId(buffer.readString());
		message.setTo(buffer.readLong());
		message.setFrom(buffer.readLong());
		message.setType(buffer.readByte());
		message.setMessage(buffer.readString());
		message.setCreateAt(buffer.readLong());
		message.setFromServer(buffer.readString());
		message.setToServer(buffer.readString());
	}
}
