package com.min.edu.model;

import org.apache.log4j.Logger;

public class LoggerTestMain {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(LoggerTestMain.class);
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
