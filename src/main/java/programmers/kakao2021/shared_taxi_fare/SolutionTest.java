package programmers.kakao2021.shared_taxi_fare;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	public void test1() {
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		int actual = s.solution(6, 4, 6, 2, fares);
		assertEquals(82, actual);
	}
	
	@Test
	public void test2() {
		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		int actual = s.solution(7, 3, 4, 1, fares);
		assertEquals(14, actual);
	}
	
	@Test
	public void test3() {
		int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
		int actual = s.solution(6, 4, 5, 6, fares);
		assertEquals(18, actual);
	}

}
