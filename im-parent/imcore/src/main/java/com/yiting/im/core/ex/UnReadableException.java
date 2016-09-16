package com.yiting.im.core.ex;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class UnReadableException extends Exception {

	public UnReadableException() {
		super();
	}

	public UnReadableException(String message) {
		super(message);
	}

	public UnReadableException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnReadableException(Throwable cause) {
		super(cause);
	}

	protected UnReadableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
