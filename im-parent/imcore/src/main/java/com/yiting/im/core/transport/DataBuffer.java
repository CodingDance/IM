package com.yiting.im.core.transport;

import com.yiting.im.core.ex.UnReadableException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Collections;
import java.util.List;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class DataBuffer {
	protected ByteBuf mBuffer;

	public DataBuffer() {
		mBuffer = Unpooled.buffer();
	}

	public DataBuffer(int length) {
		mBuffer = Unpooled.buffer(length);
	}

	public DataBuffer(ByteBuf byteBuf) {
		this.mBuffer = byteBuf;
	}

	public boolean isReadable() {
		return mBuffer.isReadable();
	}

	public boolean isWritable() {
		return mBuffer.isWritable();
	}

	public byte[] array() {
		return mBuffer.array();
	}

	public void setOrignalBuffer(ByteBuf buffer) {
		this.mBuffer = buffer;
	}

	public ByteBuf getOrignalBuffer() {
		return mBuffer;
	}

	public void writeByte(int value) {
		mBuffer.writeByte(value);
	}

	public byte readByte() {
		return mBuffer.readByte();
	}

	public void writeBytes(byte[] bytes) {
		mBuffer.writeBytes(bytes);
	}

	public byte[] readBytes(int length) {
		byte[] bytes = new byte[length];
		mBuffer.readBytes(bytes);
		return bytes;
	}

	public int readInt() throws UnReadableException {
		if (isReadable()) {
			return mBuffer.readInt();
		}
		throw new UnReadableException();
	}


	public void writeInt(int value) {
		mBuffer.writeInt(value);
	}

	public short readShort() throws UnReadableException {
		if (mBuffer.isReadable()) {
			return mBuffer.readShort();
		}
		throw new UnReadableException();
	}

	public void writeShort(int value) {
		mBuffer.writeShort(value);
	}

	public char readChar() {
		return mBuffer.readChar();
	}

	public void writeChar(char c) {
		mBuffer.writeChar(c);
	}

	public long readLong() throws UnReadableException {
		if (mBuffer.isReadable()) {
			return mBuffer.readLong();
		}
		throw new UnReadableException();
	}

	public void writeLong(long value) {
		mBuffer.writeLong(value);
	}

	public double readDouble()throws UnReadableException {
		if (mBuffer.isReadable()) {
			return mBuffer.readDouble();
		}

		throw new UnReadableException();
	}

	public void writeDouble(double value) {
		mBuffer.writeDouble(value);
	}

	/**
	 * 读取一个字符串
	 *
	 * @return 格式：前导length表示字符串的byte数 length(4字节)string(length字节)
	 */
	public String readString()throws UnReadableException {
		int length = readInt();
		byte[] bytes = readBytes(length);

		return new String(bytes);
	}

	/**
	 * 写入一个字符串
	 *
	 * @param str 数据格式见方法readString()
	 */
	public void writeString(String str) {
		if (str == null) {
			str = "";
		}
		byte[] bytes = str.getBytes();
		writeInt(bytes.length);
		writeBytes(bytes);
	}

	/**
	 * 读取int数组
	 *
	 * @return 格式：前导count表示数组中有多少个元素 count(4字节)int1(4字节)...intCount(4字节)
	 */
	public int[] readIntArray() throws UnReadableException{
		int count = readInt();
		int[] intArray = new int[count];
		for (int i = 0; i < count; i++) {
			intArray[i] = readInt();
		}
		return intArray;
	}

	/**
	 * 写入int数组
	 *
	 * @param intArray 格式见readIntArray()
	 */
	public void writeIntArray(int[] intArray) {
		int count = intArray.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeInt(intArray[i]);
		}
	}

	/**
	 * @param intList
	 * @Description: 写入一个int的list, list转数组太蛋疼了
	 */
	public void writeIntList(List<Integer> intList) {
		if (intList == null || intList.isEmpty()) {
			writeInt(0);
			return;
		}
		int count = intList.size();
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeInt(intList.get(i));
		}
	}

	/**
	 * 读取byte数组
	 *
	 * @return 格式：前导count表示数组中有多少个元素 count(4字节)byte1(4字节)...byteCount(4字节)
	 */
	public byte[] readByteArray() throws UnReadableException {
		int length = readInt(); // 获取长度
		byte[] bytes = new byte[length];
		mBuffer.readBytes(bytes);
		return bytes;
	}

	/**
	 * 写入byte数组
	 *
	 * @param byteArray 格式见readByteArray()
	 */
	public void writeByteArray(byte[] byteArray) {
		int length = byteArray.length;
		writeInt(length);
		mBuffer.writeBytes(byteArray);
	}

	/**
	 * 读取String数组
	 *
	 * @return 格式：前导count表示数组中有多少个元素 count(4字节)string1(4字节)...stringsCount(4字节)
	 */
	public String[] readStringArray() throws UnReadableException{
		int count = readInt(); // 获取长度
		String[] strArray = new String[count];
		for (int i = 0; i < count; i++) {
			strArray[i] = readString();
		}
		return strArray;
	}

	/**
	 * 写入String数组
	 *
	 * @param strArray 格式见readStringArray()
	 */
	public void writeStringArray(String[] strArray) {
		int count = strArray.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeString(strArray[i]);
		}
	}

	/**
	 * 获取有效(可读取)的byte数
	 *
	 * @return
	 */
	public int readableBytes() {
		return mBuffer.readableBytes();
	}

	public DataBuffer readDataBuffer() {
		if (mBuffer == null || mBuffer.readableBytes() == 0) {
			return new DataBuffer(0);
		}
		int length = readableBytes();
		DataBuffer dataBuffer = new DataBuffer(0);
		dataBuffer.setOrignalBuffer(mBuffer.readBytes(length));
		return dataBuffer;
	}

	public void writeDataBuffer(DataBuffer inputBuffer) {
		if (inputBuffer == null || inputBuffer.readableBytes() == 0) {
			return;
		}
		mBuffer.writeBytes(inputBuffer.mBuffer);
	}


}
