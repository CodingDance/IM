package com.yiting.im.core.transport;

import com.yiting.im.core.ex.UnReadableException;
import org.apache.log4j.Logger;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class IMRequest {
	private Logger logger = Logger.getLogger(IMRequest.class);

	protected Header mHeader;
	protected DataBuffer mBuffer;

	public IMRequest() {
	}

	public Header getmHeader() {
		return mHeader;
	}

	public void setmHeader(Header mHeader) {
		this.mHeader = mHeader;
	}

	public DataBuffer getmBuffer() {
		return mBuffer;
	}

	public void setmBuffer(DataBuffer mBuffer) {
		this.mBuffer = mBuffer;
	}

	/**
	 * 读取对象
	 *
	 * @param entity
	 * @param <T>
	 * @return
	 */
	public <T extends IMSerializer> T readEntity(T entity) {
		try {
			entity.decode(mBuffer, mHeader.getVersion());
			return entity;
		} catch (UnReadableException e) {
			logger.error(e);
		}
		return null;

	}

	/**
	 * 读取对象
	 *
	 * @param entityClass
	 * @param <T>
	 * @return
	 */
	public <T extends IMSerializer> T readEntity(Class<T> entityClass) {
		try {
			T entity = entityClass.newInstance();
			readEntity(entity);
			return entity;
		} catch (Exception e){
			logger.error("entity new instance error!!!");
		}
		return null;

	}


	/**
	 * Length | Header | Actual Content
	 *
	 * @param buffer
	 */
	public void decode(DataBuffer buffer) {
		if (buffer != null) {
			try {
				int length = buffer.readInt();
				mHeader = new Header();
				mHeader.setLength(length);
				mHeader.decode(buffer, mHeader.getVersion());
				mBuffer = buffer.readDataBuffer();
			} catch (UnReadableException e) {
				e.printStackTrace();
			}
		}

	}

}
