package practice;


import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;

public class LogTest {
	private Logger logger;
	
	public void addAppenderWithoutStream() {
		logger = Logger.getLogger("logger");
		logger.info("?????");
		assertTrue(true);
	}
	
	public static void main(String[] args) {
		LogTest logTest = new LogTest();
		logTest.addAppenderWithoutStream();
	}
}
