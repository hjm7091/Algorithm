package Programmers.kakao2021.recommend_new_id;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution solution = new Solution();
	
	@Test
	public void test1() {
		String input = "...!@BaT#*..y.abcdefghijklm";
		String expected = "bat.y.abcdefghi";
		String actual = solution.solution(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String input = "z-+.^.";
		String expected = "z--";
		String actual = solution.solution(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String input = "=.=";
		String expected = "aaa";
		String actual = solution.solution(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		String input = "123_.def";
		String expected = "123_.def";
		String actual = solution.solution(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		String input = "abcdefghijklmn.p";
		String expected = "abcdefghijklmn";
		String actual = solution.solution(input);
		assertEquals(expected, actual);
	}

}
