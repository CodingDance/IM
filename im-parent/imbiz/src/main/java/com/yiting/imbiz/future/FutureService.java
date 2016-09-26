package com.yiting.imbiz.future;

/**
 * Created by hzyiting on 2016/9/18.
 */
public interface FutureService<T> {
	/**
	 * 执行的方法
	 * @param args
	 * @return
	 */
	T handler(Object... args);

	/**
	 * 成功后执行
	 * @param result
	 * @param args
	 */
	void onSucess(Object result, Object... args);

	/**
	 * 失败后执行
	 * @param throwable
	 * @param args
	 */
	void onFailure(Throwable throwable, Object... args);
}
