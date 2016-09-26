package com.yiting.imbiz.future;

import com.google.common.util.concurrent.*;
import org.apache.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by hzyiting on 2016/9/18.
 */
public class IntFuture {
	private static final Logger logger = Logger.getLogger(IntFuture.class);
	private static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));

	public static void exec(final FutureService futureService, final Object... args) {
		ListenableFuture<Object> explosion = executorService.submit(new Callable<Object>() {

			public Object call() throws Exception {
				return futureService.handler(args);
			}

		});

		Futures.addCallback(explosion, new FutureCallback<Object>() {

			public void onSuccess(Object obj) {
				futureService.onSucess(obj, args);
			}

			public void onFailure(Throwable throwable) {
				futureService.onFailure(throwable, args);
			}
		});


	}
}
