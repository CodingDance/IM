package com.yiting.imbiz.dto;

import com.yiting.im.core.ex.UnReadableException;
import com.yiting.im.core.ex.UnWritableException;
import com.yiting.im.core.transport.DataBuffer;
import com.yiting.im.core.transport.IMSerializer;
import com.yiting.imbiz.entity.Login;

/**
 * Created by hzyiting on 2016/9/18.
 */
public class LoginDTO implements IMSerializer {

	private Login login;

	public LoginDTO() {
	}

	public LoginDTO(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public DataBuffer encode(short version) throws UnWritableException {
		DataBuffer dataBuffer=new DataBuffer();
		dataBuffer.writeLong(login.getUin());
		dataBuffer.writeString(login.getAuthToken());
		dataBuffer.writeLong(login.getActiveTime());
		return dataBuffer;
	}

	public void decode(DataBuffer buffer, short version) throws UnReadableException {
		if(login == null) {
			login = new Login();
		}
		login.setUin(buffer.readLong());
		login.setAuthToken(buffer.readString());
		login.setActiveTime(buffer.readLong());
	}

	@Override
	public String toString() {
		return "LoginDTO{" +
				"login=" + login +
				'}';
	}
}
