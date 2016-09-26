package com.yiting.im.core.cache;


import java.util.Collection;

/**
 * Created by hzyiting on 2016/9/26.
 */
public class SimpleCacheManager extends AbstractCacheManager {

	private Collection<? extends Cache> caches;


	/**
	 * Specify the collection of Cache instances to use for this CacheManager.
	 */
	public void setCaches(Collection<? extends Cache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends Cache> loadCaches() {
		return this.caches;
	}

}
