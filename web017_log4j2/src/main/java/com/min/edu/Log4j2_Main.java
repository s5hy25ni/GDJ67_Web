package com.min.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2_Main {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Log4j2_Main.class);
		logger.info("info 작성");
	}

}
