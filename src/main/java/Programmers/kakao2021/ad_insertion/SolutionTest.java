package Programmers.kakao2021.ad_insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
	
	Solution s = new Solution();

	@Test
	public void case1() {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		String actual = s.solution(play_time, adv_time, logs);
		assertEquals("01:30:59", actual);
	}
	
	@Test
	public void case2() {
		String play_time = "99:59:59";
		String adv_time = "25:00:00";
		String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		String actual = s.solution(play_time, adv_time, logs);
		assertEquals("01:00:00", actual);
	}
	
	@Test
	public void case3() {
		String play_time = "50:00:00";
		String adv_time = "50:00:00";
		String[] logs = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		String actual = s.solution(play_time, adv_time, logs);
		assertEquals("00:00:00", actual);
	}

}
