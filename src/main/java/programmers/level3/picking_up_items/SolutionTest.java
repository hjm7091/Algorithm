package programmers.level3.picking_up_items;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	Solution s = new Solution();
	
	@Test
	public void test1() {
		int[][] rectangle = {
			{1, 1, 7, 4},
			{3, 2, 5, 5},
			{4, 3, 6, 9},
			{2, 6, 8, 8}
		};
		int characterX = 1, characterY = 3, itemX = 7, itemY = 8;
		int expected = 17;
		assertThat(s.solution(rectangle, characterX, characterY, itemX, itemY)).isEqualTo(expected);
	}

	@Test
	public void test2() {
		int[][] rectangle = {
			{1, 1, 8, 4},
			{2, 2, 4, 9},
			{3, 6, 9, 8},
			{6, 3, 7, 7}
		};
		int characterX = 9, characterY = 7, itemX = 6, itemY = 1;
		int expected = 11;
		assertThat(s.solution(rectangle, characterX, characterY, itemX, itemY)).isEqualTo(expected);
	}

	@Test
	public void test3() {
		int[][] rectangle = {
			{1, 1, 5, 7}
		};
		int characterX = 1, characterY = 1, itemX = 4, itemY = 7;
		int expected = 9;
		assertThat(s.solution(rectangle, characterX, characterY, itemX, itemY)).isEqualTo(expected);
	}

	@Test
	public void test4() {
		int[][] rectangle = {
			{2, 1, 7, 5},
			{6, 4, 10, 10}
		};
		int characterX = 3, characterY = 1, itemX = 7, itemY = 10;
		int expected = 15;
		assertThat(s.solution(rectangle, characterX, characterY, itemX, itemY)).isEqualTo(expected);
	}

	@Test
	public void test5() {
		int[][] rectangle = {
			{2, 2, 5, 5},
			{1, 3, 6, 4},
			{3, 1, 4, 6}
		};
		int characterX = 1, characterY = 4, itemX = 6, itemY = 3;
		int expected = 10;
		assertThat(s.solution(rectangle, characterX, characterY, itemX, itemY)).isEqualTo(expected);
	}

}
