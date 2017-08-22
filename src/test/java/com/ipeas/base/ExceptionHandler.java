package com.ipeas.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

	public void uncaughtException(Thread t, Throwable e) {
		handle(e);
	}

	public void handle(Throwable throwable) {
		try {
			LOG.error("exception occured: {}", throwable.fillInStackTrace());
		} catch (Throwable t) {
			LOG.error(t.getMessage());
		}
	}

	public static void registerExceptionHandler() {
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		System.setProperty("sun.awt.exception.handler", ExceptionHandler.class.getName());
	}
}
