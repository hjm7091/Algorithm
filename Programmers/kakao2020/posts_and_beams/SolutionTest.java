package posts_and_beams;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	void test1() {
		int n = 5;
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] actual = s.solution(n, build_frame);
		int[][] expected = {{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test2() {
		int n = 5;
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] actual = s.solution(n, build_frame);
		int[][] expected = {{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}};
		assertArrayEquals(expected, actual);
	}

}
