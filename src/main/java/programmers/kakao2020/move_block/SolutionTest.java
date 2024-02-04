package programmers.kakao2020.move_block;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	void test() {
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		assertThat(s.solution(board)).isEqualTo(7);
	}

}
