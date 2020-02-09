package word_conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SolutionTest {

	private Solution s = new Solution();
	
	@Test
	public void case1() {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		assertEquals(4, s.solution(begin, target, words));
	}
	
	@Test
	public void case2() {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		assertEquals(0, s.solution(begin, target, words));
	}
	
}
