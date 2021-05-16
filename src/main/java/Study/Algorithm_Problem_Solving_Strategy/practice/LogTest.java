package Study.Algorithm_Problem_Solving_Strategy.practice;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
