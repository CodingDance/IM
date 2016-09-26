package com.yiting.handler;

import com.yiting.bean.Constants;
import com.yiting.bean.RouteData;
import com.yiting.bean.RouteResponse;
import com.yiting.config.CachingConfiguration;
import com.yiting.im.core.cache.Cache;
import com.yiting.im.core.cache.CacheManager;
import com.yiting.im.core.connection.IMConnection;
import com.yiting.im.core.handler.IMHandler;


/**
 * Created by hzyiting on 2016/9/26.
 */
public class UserRouteDataHandler extends IMHandler<RouteData> {

	private CacheManager cacheManager=CachingConfiguration.getCacheManagerInstance();

	@Override
	public short getId() {
		return Constants.ROUTE_TO_USER_TYPE;
	}

	@Override
	public void dispatch(IMConnection connection, RouteData data) {
		Cache onlineCache=cacheManager.getCache(Constants.CACHE_USER_ONLINE);
		Cache serverCache=cacheManager.getCache(Constants.CACHE_SERVERS);
		long serverId=onlineCache.get(data.getTo(),Long.class);
		IMConnection toConn=serverCache.get(serverId,IMConnection.class);
		if(toConn!=null){
			toConn.sendResponse(new RouteResponse(data.getData()));
		}

	}
}
