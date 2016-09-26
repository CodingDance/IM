package com.yiting.im.core.cache;

/**
 * Created by hzyiting on 2016/9/26.
 */
public class SimpleValueWrapper implements Cache.ValueWrapper {

	private final Object value;


	/**
	 * Create a new SimpleValueWrapper instance for exposing the given value.
	 * @param value the value to expose (may be {@code null})
	 */
	public SimpleValueWrapper(Object value) {
		this.value = value;
	}


	/**
	 * Simply returns the value as given at construction time.
	 */
	@Override
	public Object get() {
		return this.value;
	}

}
