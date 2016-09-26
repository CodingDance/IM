package com.yiting.config;


import com.yiting.bean.Constants;
import com.yiting.im.core.cache.Cache;
import com.yiting.im.core.cache.CacheManager;
import com.yiting.im.core.cache.ConcurrentMapCache;
import com.yiting.im.core.cache.SimpleCacheManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 2/22/15.
 */
public class CachingConfiguration {
	private static SimpleCacheManager cacheManager;

	public static CacheManager getCacheManagerInstance() {
		if (cacheManager == null) {
			synchronized (CachingConfiguration.class) {
				if(cacheManager==null) {
					cacheManager = new SimpleCacheManager();

					List<Cache> caches = new ArrayList<Cache>();
					// Ehcache/Redis
					caches.add(new ConcurrentMapCache(Constants.CACHE_USER_ONLINE, false));
					caches.add(new ConcurrentMapCache(Constants.CACHE_SERVERS, false));
					cacheManager.setCaches(caches);
				}
			}
		}

		return cacheManager;
	}


}
