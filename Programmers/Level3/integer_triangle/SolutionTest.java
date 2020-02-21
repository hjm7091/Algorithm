package integer_triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private Solution s = new Solution();
	
	@Test
	public void case1() {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		assertEquals(30, s.solution(triangle));
	}
	
	
}
