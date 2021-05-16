package Programmers.Level3.integer_triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

	private Solution s = new Solution();
	
	@Test
	public void case1() {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		assertEquals(30, s.solution(triangle));
	}
	
	
}
