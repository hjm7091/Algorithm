package Programmers.kakao2020.exterior_wall_inspection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	void test1() {
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		assertThat(s.solution(n, weak, dist)).isEqualTo(2);
	}
	
	@Test
	void test2() {
		int n = 12;
		int[] weak = {1, 3, 4, 9, 10};
		int[] dist = {3, 5, 7};
		assertThat(s.solution(n, weak, dist)).isEqualTo(1);
	}
	
	@Test
	void test3() {
		int n = 50;
		int[] weak = {1, 5, 10, 12, 22, 25};
		int[] dist = {4, 3, 2, 1};
		assertThat(s.solution(n, weak, dist)).isEqualTo(3);
	}

	@Test
	void test4() {
		int n = 50;
		int[] weak = {1, 5, 10, 16, 22, 25};
		int[] dist = {3, 4, 6};
		assertThat(s.solution(n, weak, dist)).isEqualTo(3);
	}
	
	@Test
	void test5() {
		int n = 50;
		int[] weak = {1};
		int[] dist = {6};
		assertThat(s.solution(n, weak, dist)).isEqualTo(1);
	}
}
