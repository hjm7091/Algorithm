package security_camera;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private Solution s = new Solution();
	
	@Test
	public void case1() {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		assertEquals(2, s.solution(routes));
	}
	
	@Test
	public void case2() {
		int[][] routes = {{0,0}, {0,0}, {2,2}};
		assertEquals(2, s.solution(routes));
	}
	
	@Test
	public void case3() {
		int[][] routes = {{0,1}, {0,1}, {2,2}};
		assertEquals(2, s.solution(routes));
	}
	
}
