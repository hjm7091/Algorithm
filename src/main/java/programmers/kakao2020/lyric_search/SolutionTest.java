package programmers.kakao2020.lyric_search;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s = new Solution();
	
	@Test
	void test1() {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] actual = s.solution(words, queries);
		int[] expected = {3, 2, 4, 1, 0};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void test2() {
		String[] words = {"frodo", "kakaoo"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] actual = s.solution(words, queries);
		int[] expected = {1, 1, 1, 0, 0};
		assertArrayEquals(expected, actual);
	}

}
