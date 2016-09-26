package com.yiting.imbiz.entity;

/**
 * Created by hzyiting on 2016/9/17.
 */
public class Message extends BaseEntity {
	//uin
	private long from;
	private long to;

	private String fromServer;
	private String toServer;

	private byte type;
	private boolean read;
	private String message;
	private long createAt;
	private long readAt;

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public String getFromServer() {
		return fromServer;
	}

	public void setFromServer(String fromServer) {
		this.fromServer = fromServer;
	}

	public String getToServer() {
		return toServer;
	}

	public void setToServer(String toServer) {
		this.toServer = toServer;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(long createAt) {
		this.createAt = createAt;
	}

	public long getReadAt() {
		return readAt;
	}

	public void setReadAt(long readAt) {
		this.readAt = readAt;
	}

	@Override
	public String toString() {
		return "Message{" +
				", id='" + id + '\'' +
				"from=" + from +
				", to=" + to +
				", fromServer='" + fromServer + '\'' +
				", toServer='" + toServer + '\'' +
				", type=" + type +
				", read=" + read +
				", message='" + message + '\'' +
				", createAt=" + createAt +
				", readAt=" + readAt +
				'}';
	}

	public enum Type {
		SESSION_MSG(0), // 临时会话消息
		USER_MSG(1),  // 好友消息
		ROOM_MSG(2),  // 群消息
		ERROR_MSG(-1);	  //错误消息
		private byte mValue = 0;

		public byte getmValue() {
			return mValue;
		}

		Type(int mValue) {
			this.mValue = (byte) mValue;
		}

		public static Type ValueOfRaw(byte value){
			for(Type type:Type.values()){
				if(type.getmValue()==value){
					return type;
				}
			}
			return ERROR_MSG;
		}

	}


}
