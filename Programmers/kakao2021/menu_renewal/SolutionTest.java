package menu_renewal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	public void test1() {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		String[] expected = {"AC", "ACDE", "BCFG", "CDE"};
		String[] actual = s.solution(orders, course);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2, 3, 5};
		String[] expected = {"ACD", "AD", "ADE", "CD", "XYZ"};
		String[] actual = s.solution(orders, course);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		String[] expected = {"WX", "XY"};
		String[] actual = s.solution(orders, course);
		assertArrayEquals(expected, actual);
	}

}
