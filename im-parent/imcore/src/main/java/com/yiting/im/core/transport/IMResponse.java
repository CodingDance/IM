package com.yiting.im.core.transport;

import com.yiting.im.core.ex.UnWritableException;
import org.apache.log4j.Logger;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class IMResponse {
	private Logger logger = Logger.getLogger(IMResponse.class);
	private Header mHeader;
	private DataBuffer mBuffer;

	public Header getmHeader() {
		return mHeader;
	}

	public void setmHeader(Header mHeader) {
		this.mHeader = mHeader;
	}

	public DataBuffer getmBuffer() {
		return mBuffer;
	}

	public void setmBuffer(DataBuffer buffer) {
		this.mBuffer = buffer;
	}

	/**
	 * 写入DataBuffer对象到Data
	 *
	 * @param buffer
	 */
	public void writeData(DataBuffer buffer) {
		if (this.mBuffer == null) {
			this.mBuffer = new DataBuffer();
		}
		this.mBuffer.writeDataBuffer(buffer);
	}

	public <T extends IMSerializer> void writeEntity(T entity) {
		try {
			writeData(entity.encode(mHeader.getVersion()));
		} catch (UnWritableException e) {
			logger.error(e);
		}
	}

	public DataBuffer encode() {
		try {
			DataBuffer dataBuffer = new DataBuffer();
			int length = Header.PROTOCOL_HEADER_LENGTH;
			if (mBuffer != null) {
				length += mBuffer.readableBytes();
			}
			dataBuffer.writeInt(length);
			mHeader.setLength(length);
			dataBuffer.writeDataBuffer(mHeader.encode(mHeader.getVersion()));
			dataBuffer.writeDataBuffer(mBuffer);
			return dataBuffer;
		} catch (Exception ex) {
			logger.error(ex);
		}
		return null;
	}


}
