package com.yiting.im.core.ex;

/**
 * Created by hzyiting on 2016/9/13.
 */
public class UnWritableException extends Exception {
	public UnWritableException() {
		super();
	}

	public UnWritableException(String message) {
		super(message);
	}

	public UnWritableException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnWritableException(Throwable cause) {
		super(cause);
	}

	protected UnWritableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
